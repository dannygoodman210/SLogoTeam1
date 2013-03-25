package frontEnd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
import util.Trail;
import util.Vector;
import backEnd.Turtle;


/**
 * TurtleView class extends JComponent. Receives information from Canvas in the form of a Turtle
 * Object. Draws Turtle and lines generated by Turtle movement.
 * 
 * @author Danny Goodman, David Le
 */
public class TurtleView extends JComponent {

    private static final Color PEN_COLOR = Color.BLACK;
    private static final Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);
    private static final int DEFAULT_HEADING = 90;
    private static final Location DEFAULT_LOCATION = new Location(0, 0);
    private static final long serialVersionUID = 1L;
    private static final int VIEW_HEIGHT = 495;
    private static final int VIEW_WIDTH = 620;
    private static final int FRAMES_PER_SECOND = 1000;
    private static final int ONE_SECOND = 1000;
    private static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;

    private ResourceBundle myResources;
    private Location myTurtleLocation;
    private Location myTurtleNextLocation;
    private double myTurtleHeading;
    private boolean myTurtlePenDown;
    private boolean myTurtleVisible;
    private List<Turtle> myChangesQueue;
    private Timer myTimer;
    private TurtleDrawer myTurtleDrawer;
    private int[] myTurtleWarps;
    private WorkspaceView myView;
    private Color myBackgroundColor;

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
        myTurtleDrawer = new DefaultTurtleDrawer(this);
        myBackgroundColor = Color.WHITE;
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
        drawTurtle(pen);
        drawGrid(pen);
    }

    /**
     * Adds a Turtle object to the queue to be updated from later.
     * 
     * @param changedTurtle - Turtle object containing changes in instance variables
     */
    public void addToQueue (Turtle changedTurtle) {
        myChangesQueue.add(changedTurtle);
    }

    /**
     * Updates the Turtle parameters based on the new Turtle information. Calls repaint().
     * 
     * @param changedTurtle - contains changes in instance variables
     */
    public void updateTurtle (Turtle changedTurtle) {
        myTurtleNextLocation = changedTurtle.getLocation();
        myTurtleHeading = changedTurtle.getHeading();
        myTurtlePenDown = changedTurtle.isPenDown();
        myTurtleVisible = changedTurtle.isVisible();
        repaint();
    }

    /**
     * Clears the trails from the List so that they are no longer painted.
     */
    public void clearTrails () {
        myTurtleDrawer.clearTrail();
        repaint();
    }

    /**
     * ToggleWarp. Called by viewMenu item. Calls toggleDecorator with the WarpTurtleDrawer
     * decorator.
     */
    public void toggleWarp () {
        toggleDecorator(new WarpTurtleDrawer(new DefaultTurtleDrawer(this)));
    }

    /**
     * ToggleFill. Called by viewMenu item. Calls toggleDecorator with the FillTurtleDrawer
     * decorator. Draws the body of the turtle as a filled in triangle.
     */
    public void toggleFill () {
        toggleDecorator(new FilledTurtleDrawer(new DefaultTurtleDrawer(this)));
    }

    /**
     * Returns the int[] of turtleWarps.
     * 
     * @return myTurtleWarps
     */
    public int[] getTurtleWarps () {
        return myTurtleWarps;
    }

    /**
     * sets myTurtleWarps to the given int[].
     * 
     * @param warps - int[] containing warpTotals.
     */
    public void setTurtleWarps (int[] warps) {
        this.myTurtleWarps = warps;
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
     * Updates turtle based on next turtle in the queue. Called by the timer.
     */
    private void checkQueue () {
        if (!myChangesQueue.isEmpty()) {
            updateTurtle(myChangesQueue.remove(0));
        }
    }

    /**
     * Calls TurtleDrawer functions to draw the Turtle.
     * 
     * @param pen
     */
    private void drawTurtle (Graphics pen) {
        if (myTurtlePenDown) {
            pen.setColor(PEN_COLOR);
        }
        else {
            pen.setColor(TRANSPARENT_COLOR);
        }
        myTurtleDrawer.addTrail(calculateWarps(new Location(myTurtleLocation), myTurtleWarps),
                                calculateWarps(new Location(myTurtleNextLocation),
                                               myTurtleWarps), pen);
        myTurtleDrawer.drawTrail(pen);
        if (myTurtleVisible) {
            pen.setColor(PEN_COLOR);
        }
        else {
            pen.setColor(TRANSPARENT_COLOR);
        }
        myTurtleDrawer.drawBody(pen, myTurtleHeading);
        myTurtleLocation = new Location(myTurtleNextLocation);
    }

    // resets TurtleParameters.
    private void resetTurtleView () {
        myTurtleLocation = DEFAULT_LOCATION;
        myTurtleNextLocation = DEFAULT_LOCATION;
        myTurtleHeading = DEFAULT_HEADING;
        myTurtlePenDown = true;
        myTurtleVisible = true;
        resetWarps();
        clearTrails();
        myChangesQueue = new ArrayList<Turtle>();
    }

    // resets myTurtleWarps.
    private void resetWarps () {
        myTurtleWarps = new int[] { 0, 0, 0, 0 };
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
    private void toggleDecorator (DecoratedTurtleDrawer decorator) {
        myTimer.stop();
        Set<TurtleDrawer> referenceSet = myTurtleDrawer.getReferences();
        if (referenceSet.contains(decorator)) {
            myTurtleDrawer = myTurtleDrawer.removeReference(decorator);
        }
        else {
            try {
                myTurtleDrawer = decorator.getClass().
                        getConstructor(TurtleDrawer.class).newInstance(myTurtleDrawer);
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
     * Sets color of background in this workspace.
     * 
     * @param color to be set to
     */
    public void setBackgroundColor (Color color) {
    	myBackgroundColor = color;
    	repaint();
    }
    
    /**
     * Draws grid which can be toggled on and off.
     * 
     * @param pen used to draw grid
     */
    public void drawGrid (Graphics pen) {
        int xLength = (int) getBounds().getWidth();
        int yLength = (int) getBounds().getHeight();
        int centerX = xLength/2;
        int centerY = yLength/2;
        int xLine = 0;
        int yLine = 0;
        while (xLine < xLength) {
        	pen.drawLine(centerX+xLine, 0, centerX+xLine, yLength);
        	pen.drawLine(centerX-xLine, 0, centerX-xLine, yLength);
        	xLine += 100;
        }
        while (yLine < yLength) {
        	pen.drawLine(0, centerY+yLine, xLength, centerY+yLine);
        	pen.drawLine(0, centerY-yLine, xLength, centerY-yLine);
        	yLine += 100;
        }
    }
}
