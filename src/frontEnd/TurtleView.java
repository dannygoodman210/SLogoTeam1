package frontEnd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import util.Location;
import util.Vector;
import backEnd.Turtle;


public class TurtleView extends JComponent {

    private static final long serialVersionUID = 1L;
    private static final int VIEW_HEIGHT = 488;
    private static final int VIEW_WIDTH = 600;
    public static final double TURTLE_SIZE = 16;

    private boolean isInitialized;
    private Location myTurtleLocation;
    private Location myTurtleNextLocation;
    private double myTurtleHeading;
    private boolean myTurtlePenDown;
    private boolean myTurtleVisible;

    public TurtleView () {
        setPreferredSize(new Dimension(VIEW_WIDTH, VIEW_HEIGHT));
        setFocusable(true);
        requestFocus();
        resetTurtle();
        isInitialized = false;
    }

    /**
     * Paint the contents of the canvas.
     * 
     * Never called by you directly, instead called by Java runtime
     * when area of screen covered by this container needs to be
     * displayed (i.e., creation, uncovering, change in status)
     * 
     * @param pen used to paint shape on the screen
     */
    @Override
    public void paintComponent (Graphics pen) {
        if (!isInitialized) {
            initialize(pen);
            isInitialized = true;
        }
        else{
            drawTurtle(pen);
        }
    }

    public void initialize (Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
    }

    private void drawTurtle (Graphics pen) {
        drawLines(pen);
        myTurtleLocation = myTurtleNextLocation;
        
  }

    private void drawLines (Graphics pen) {
        pen.setColor(Color.BLACK);
        Location start = translateCoordinates(myTurtleLocation);
        Location finish = translateCoordinates(myTurtleNextLocation);
        pen.drawLine((int) start.getX(), (int) start.getY(),
                     (int) finish.getX(), (int) finish.getY());
    }

    private Location translateCoordinates (Location point) {
        double centerX = getBounds().getWidth() / 2;
        double centerY = getBounds().getHeight() / 2;
        return new Location(point.getX() + centerX, point.getY() + centerY);
    }

    public void updateTurtle (Turtle changedTurtle) {
        myTurtleNextLocation = changedTurtle.getLocation();
        myTurtleHeading = changedTurtle.getHeading();
        myTurtlePenDown = changedTurtle.isPenDown();
        myTurtleVisible = changedTurtle.isVisible();
        repaint();
    }

    public void resetTurtle () {
        myTurtleLocation = Turtle.INITIAL_LOCATION;
        myTurtleHeading = Turtle.UP_DIRECTION;
        myTurtlePenDown = true;
        myTurtleVisible = true;
    }

}
