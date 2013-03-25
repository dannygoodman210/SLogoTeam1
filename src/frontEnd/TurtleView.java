package frontEnd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.Timer;
import util.Location;
import util.Palette;
import util.Trail;
import util.Vector;
import backEnd.Turtle;
import backEnd.TurtleList;
import backEnd.Workspace;


/**
 * TurtleView class extends JComponent. Receives information from Canvas in the form of a Turtle
 * Object. Draws Turtle and lines generated by Turtle movement.
 * 
 * @author Danny Goodman, David Le
 */
public class TurtleView extends JComponent {

    private static final Color PEN_COLOR = Color.BLACK;
    private static final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);
    private static final long serialVersionUID = 1L;
    private static final int VIEW_HEIGHT = 495;
    private static final int VIEW_WIDTH = 620;
    private static final int FRAMES_PER_SECOND = 1000;
    private static final int ONE_SECOND = 1000;
    private static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;

    private ResourceBundle myResources;
    private Timer myTimer;
    private List<Workspace> myWorkspaceChanges;
    private List<TurtleDrawer> myTurtleDrawers;
    private List<int[]> myTurtleWarps;
    private WorkspaceView myView;
    private Color myBackgroundColor;

    private TurtleList myTurtleList;
    private TurtleList myNextTurtleList;
    private Palette myPalette;

    private boolean myGrid;


    /**
     * TurtleView Constructor. Sets size. Initializes turtle parameters.
     */
    public TurtleView (WorkspaceView view) {
        setPreferredSize(new Dimension(VIEW_WIDTH, VIEW_HEIGHT));
        setFocusable(true);
        requestFocus();
        myView = view;
        myResources = myView.getView().getResources();
        getBounds().setBounds(0, 0, getBounds().width, getBounds().height);
        myTimer = new Timer(DEFAULT_DELAY, new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                checkQueue();
            }
        });
        resetTurtleView();
        myTimer.start();
    }

    /**
     * Paint the contents of the canvas.
     * 
     * Never called by you directly, instead called by Java runtime
     * when area of screen covered by this container needs to be
     * displayed (i.e., creation, uncovering, change in status)
     * 
     * @param pen - used to paint shape on the screen
     */
    @Override
    public void paintComponent (Graphics pen) {
        pen.setColor(myBackgroundColor);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        for (int i = 0; i < myTurtleList.size(); i++) {
            drawTurtle((Graphics2D) pen, i);
        }
        myTurtleList = myNextTurtleList;

    }

    public void addToQueue (Workspace changedWorkspace) {
        myWorkspaceChanges.add(changedWorkspace);

    }

    /**
     * Clears the trails from the List so that they are no longer painted.
     */
    public void clearAllTrails () {
        for (TurtleDrawer turtleDrawer : myTurtleDrawers) {
            turtleDrawer.clearTrail();
        }
        repaint();
    }

    /**
     * ToggleWarp. Called by viewMenu item. Calls toggleDecorator with the WarpTurtleDrawer
     * decorator.
     */
    public void toggleWarp () {
        for (Integer i : myTurtleList.getActiveIDs()) {
            toggleDecorator(new WarpTurtleDrawer(new DefaultTurtleDrawer(this, i)), i);
        }
    }

    /**
     * ToggleFill. Called by viewMenu item. Calls toggleDecorator with the FillTurtleDrawer
     * decorator. Draws the body of the turtle as a filled in triangle.
     */
    public void toggleFill () {
        for (Integer i : myTurtleList.getActiveIDs()) {
            toggleDecorator(new FilledTurtleDrawer(new DefaultTurtleDrawer(this, i)), i);
        }
    }

    /**
     * Returns the int[] of turtleWarps.
     * 
     * @return myTurtleWarps
     */
    public int[] getTurtleWarps (int turtleIndex) {
        return myTurtleWarps.get(turtleIndex);
    }

    /**
     * sets myTurtleWarps to the given int[].
     * 
     * @param warps - int[] containing warpTotals.
     */
    public void setTurtleWarps (int turtleIndex, int[] warps) {
        myTurtleWarps.set(turtleIndex, warps);
    }

    /**
     * Translates Coordinates from (0,0) centered to (0,0) in the top left corner.
     * 
     * @param point - Location to be translated
     * @return Translated Location
     */
    public Location translateCoordinates (Location point) {
        int centerX = (int) getBounds().getWidth() / 2;
        int centerY = (int) getBounds().getHeight() / 2;
        return new Location(centerX + point.getX(), centerY - point.getY());
    }

    /**
     * Return true if the point is outside of the view's bounds.
     * 
     * @param point
     * @return true if outside of bounds.
     */
    public boolean isOutsideBounds (Location point) {
        Location translatedPoint = translateCoordinates(point);
        Rectangle bounds = getBounds();
        return !bounds.contains(translatedPoint);
    }

    public Trail calculateWarps (Trail trail, int[] warps) {
        trail.getStart().setLocation(calculateWarps(trail.getStart(), warps));
        trail.getEnd().setLocation(calculateWarps(trail.getEnd(), warps));
        return trail;
    }

    /**
     * Sets color of background in this workspace.
     * 
     * @param color to be set to
     */
    public void setBackgroundColor (Color color) {
        myBackgroundColor = color;
        repaint();
    }

    /**
     * Updates turtle based on next turtle in the queue. Called by the timer.
     */
    private void checkQueue () {
        // if (!myChangesQueue.isEmpty()) {
        // updateTurtle(myChangesQueue.remove(0));
        // }
        if (!myWorkspaceChanges.isEmpty()) {
            updateWorkspace(myWorkspaceChanges.remove(0));
        }
    }

    // /**
    // * Updates the Turtle parameters based on the new Turtle information. Calls repaint().
    // *
    // * @param changedTurtle - contains changes in instance variables
    // */
    // private void updateTurtle (Turtle changedTurtle) {
    // myTurtleNextLocation = changedTurtle.getLocation();
    // myTurtleHeading = changedTurtle.getHeading();
    // myTurtlePenDown = changedTurtle.isPenDown();
    // myTurtleVisible = changedTurtle.isVisible();
    // repaint();
    // }

    private void updateWorkspace (Workspace changedWorkspace) {
        myBackgroundColor = changedWorkspace.getBackgroundColor();
        myPalette = changedWorkspace.getPalette();
        myNextTurtleList = changedWorkspace.getTurtleList();
        checkTurtleList();
        repaint();
    }

    private void checkTurtleList () {
        if (myNextTurtleList.size() > myTurtleList.size()) {
            int current = myTurtleList.size();
            myTurtleList.add(myNextTurtleList.get(current));
            myTurtleDrawers.add(new DefaultTurtleDrawer(this, current));
            myTurtleWarps.add(new int[] { 0, 0, 0, 0 });
        }
    }

    /**
     * Calls TurtleDrawer functions to draw the Turtle.
     * 
     * @param pen
     */
    private void drawTurtle (Graphics2D pen, int turtleIndex) {
        Turtle nextTurtle = myNextTurtleList.get(turtleIndex);
        Location nextLocation = nextTurtle.getLocation();
        Turtle currentTurtle = myTurtleList.get(turtleIndex);
        Location currentLocation = currentTurtle.getLocation();
        TurtleDrawer drawer = myTurtleDrawers.get(turtleIndex);
        int[] currentWarps = myTurtleWarps.get(turtleIndex);
        if (nextTurtle.isPenDown()) {
            pen.setColor(myPalette.getColor(nextTurtle.getPenColorIndex()));
        }
        else {
            pen.setColor(TRANSPARENT_COLOR);
        }
        drawer.addTrail(calculateWarps(new Location(currentLocation), currentWarps),
                        calculateWarps(new Location(nextLocation), currentWarps), pen);
        drawer.drawTrail(pen);
        if (nextTurtle.isVisible()) {
            drawer.drawBody(pen, nextTurtle.getHeading(), nextTurtle.getShapeIndex());
        }
    }

    // resets TurtleParameters.
    private void resetTurtleView () {
        myTurtleList = new TurtleList();
        myTurtleList.addNewTurtle(0, 0);
        myNextTurtleList = new TurtleList(myTurtleList);
        myTurtleDrawers = new ArrayList<TurtleDrawer>();
        myTurtleDrawers.add(new DefaultTurtleDrawer(this, 0));
        myBackgroundColor = Color.WHITE;
        myPalette = new Palette();
        myWorkspaceChanges = new ArrayList<Workspace>();
        myTurtleWarps = new ArrayList<int[]>();
        myTurtleWarps.add(new int[] { 0, 0, 0, 0 });
        clearAllTrails();
    }

    /**
     * Calculates the Location a point warps to given an int[] of warps.
     * 
     * @param point
     * @param warps
     * @return warped Location
     */
    private Location calculateWarps (Location point, int[] warps) {
        for (int i = 0; i < warps.length; i++) {
            double size = 0;
            if (i % 2 == 0) {
                size = getBounds().getWidth();
            }
            else {
                size = getBounds().getHeight();
            }
            Vector v = new Vector(i * 90, warps[i] * size);
            point.translate(v);
        }
        return point;
    }

    /**
     * Toggles the use of a certain DecoratedTurtleDrawer.
     * 
     * @param decorator
     */
    private void toggleDecorator (DecoratedTurtleDrawer decorator, int turtleIndex) {
        myTimer.stop();
        TurtleDrawer drawer = myTurtleDrawers.get(turtleIndex);
        Set<TurtleDrawer> referenceSet = drawer.getReferences();
        if (referenceSet.contains(decorator)) {
            drawer = drawer.removeReference(decorator);
        }
        else {
            try {
                drawer = decorator.getClass().
                        getConstructor(TurtleDrawer.class).newInstance(drawer);
            }
            catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                myView.getView().showErrorMsg(myResources.getString("DecoratorError"));
            }
        }
        repaint();
        myTimer.start();
    }

    
    /**
     * Draws grid which can be toggled on and off.
     * 
     * @param pen used to draw grid
     */
    public void drawGrid (Graphics pen) {
    	pen.setColor(Color.black);
        int centerX = (int) getBounds().getWidth()/2;
        int centerY = (int) getBounds().getHeight()/2;
        int xLine = 0;
        int yLine = 0;
        while (xLine < getBounds().getWidth()) {
        	int penPoint = 0;
        	while (penPoint < getBounds().getHeight()) {
        		pen.drawLine(centerX+xLine, penPoint, centerX+xLine, penPoint + 5);
        		pen.drawLine(centerX-xLine, penPoint, centerX-xLine, penPoint + 5);
        		penPoint += 10;
        	}
        	xLine += 100;
        }
        while (yLine < getBounds().getHeight()) {
        	int penPoint = 0;
        	while (penPoint < getBounds().getWidth()) {
            	pen.drawLine(penPoint, centerY+yLine, penPoint + 5, centerY+yLine);
            	pen.drawLine(penPoint, centerY-yLine, penPoint + 5, centerY-yLine);
            	penPoint += 10;
        	}
        	yLine += 100;
        }
    }
    
    /**
     * Toggles grid on and off; triggered by button in "View" menu.
     */
    public void toggleGrid () {
    	myGrid = !myGrid;
    	repaint();
    }

}
