package backEnd;

import java.util.Observable;
import java.util.Observer;
import util.Location;
import util.Vector;


/**
 * Turtle object extends Observable. Notifies Observer when its instance variables change.
 * 
 * @author Danny Goodman, Challen Herzberg-Brovold
 * 
 */
public class Turtle extends Observable {

    public static final int NORTH_DIRECTION = 90;
    public static final Location INITIAL_LOCATION = new Location(0, 0);
    public static final int FULL_TURN = 360;

    private Observer myObserver;
    private Location myLocation;
    private double myHeading;
    private boolean myPenDown;
    private boolean myVisible;

    /**
     * Creates a Turtle object. Pass in its observer.
     * 
     * @param observer
     */

    public Turtle (Observer observer) {
        myObserver = observer;
        addObserver(myObserver);
        setLocation(INITIAL_LOCATION);
        setHeading(NORTH_DIRECTION);
        setPenDown(false);
        setVisible(true);
    }

    /**
     * Makes a copy of the given Turtle object
     * 
     * @param o - other turtle
     */

    public Turtle (Turtle o) {
        myLocation = new Location(o.getLocation());
        myHeading = o.getHeading();
        myPenDown = o.isPenDown();
        myVisible = o.isVisible();
    }

    /**
     * Rotates the Turtle.
     * A positive degrees value will rotate counterclockwise.
     * A negative degrees value will rotate clockwise.
     * North, South, East, West mimics unit circle.
     * 
     * @param degrees - amount to rotate the Turtle
     */
    public void rotate (double degrees) {
        myHeading = myHeading + degrees;
        if (myHeading >= FULL_TURN) {
            myHeading -= FULL_TURN;
        }
        setChanged();
    }

    /**
     * Set heading towards a point.
     * 
     * @param x - x value of point
     * @param y - y value of point
     */
    public void setTowards (double x, double y) {
        Vector between = new Vector(myLocation, new Location(x, y));
        setHeading(between.getDirection());
        setChanged();
    }

    /**
     * moves Turtle number of steps in direction of myHeading.
     * 
     * @param steps - how far to move
     */
    public void move (double steps) {
        Vector moveVector = new Vector(myHeading, steps);
        myLocation.translate(moveVector);
        setChanged();
    }

    /**
     * Returns location of Turtle object
     * 
     * @return myLocation
     */
    public Location getLocation () {
        return myLocation;
    }

    /**
     * Set location of Turtle from a Location object
     * 
     * @param location - Turtle's position.
     */
    public void setLocation (Location location) {
        myLocation = location;
        setChanged();
    }

    /**
     * Set location of Turtle from an x,y coordinate.
     * 
     * @param x - x value of coordinate
     * @param y - y value of coordinate
     */
    public void setLocation (double x, double y) {
        myLocation = new Location(x, y);
        setChanged();
    }

    /**
     * Returns heading of turtle object
     * 
     * @return myHeading
     */
    public double getHeading () {
        return myHeading;
    }

    /**
     * Set heading of Turtle object
     * 
     * @param heading - angle in degrees
     */
    public void setHeading (double heading) {
        myHeading = heading;
        setChanged();
    }

    /**
     * Checks if pen is down
     * 
     * @return myPenDown
     */
    public boolean isPenDown () {
        return myPenDown;
    }

    /**
     * Set pen is down
     * 
     * @param penDown - true if pen is down
     */
    public void setPenDown (boolean penDown) {
        myPenDown = penDown;
        setChanged();
    }

    /**
     * Checks if Turtle object is visible
     * 
     * @return myVisible
     */
    public boolean isVisible () {
        return myVisible;
    }

    /**
     * Set Turtle object visible variable
     * 
     * @param visible - true if visible
     */
    public void setVisible (boolean visible) {
        myVisible = visible;
        setChanged();
    }

    @Override
    protected void setChanged () {
        super.setChanged();
        notifyObservers();
    }

}
