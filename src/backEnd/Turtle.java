package backEnd;

import java.util.Observable;
import java.util.Observer;
import util.Location;
import util.Vector;


public class Turtle extends Observable {

    public static final int NORTH_DIRECTION = 90;
    public static final Location INITIAL_LOCATION = new Location(0, 0);
    public static final int FULL_TURN = 360;

    private Observer myObserver;
    private Location myLocation;
    private double myHeading;
    private boolean myPenDown;
    private boolean myVisible;

    public Turtle (Observer observer) {
        myObserver = observer;
        addObserver(myObserver);
        setLocation(INITIAL_LOCATION);
        setHeading(NORTH_DIRECTION);
        setPenDown(true);
        setVisible(true);
    }

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
     * @param degrees
     */
    public void rotate (double degrees) {
        myHeading = myHeading + degrees;
        if (myHeading >= FULL_TURN) {
            myHeading -= FULL_TURN;
        }
        setChanged();
    }

    public void setTowards (double x, double y) {
        Vector between = new Vector(myLocation, new Location(x, y));
        setHeading(between.getDirection());
        setChanged();
    }

    public void move (double steps) {
        Vector moveVector = new Vector(myHeading, steps);
        myLocation.translate(moveVector);
        setChanged();
    }

    public Location getLocation () {
        return myLocation;
    }

    public void setLocation (Location location) {
        myLocation = location;
        setChanged();
    }

    public void setLocation (double x, double y) {
        myLocation = new Location(x, y);
        setChanged();
    }

    public double getHeading () {
        return myHeading;
    }

    public void setHeading (double heading) {
        myHeading = heading;
        setChanged();
    }

    public boolean isPenDown () {
        return myPenDown;
    }

    public void setPenDown (boolean penDown) {
        myPenDown = penDown;
        setChanged();
    }

    public boolean isVisible () {
        return myVisible;
    }

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
