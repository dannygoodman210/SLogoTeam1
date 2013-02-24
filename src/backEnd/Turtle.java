package backEnd;

import java.util.Observable;
import java.util.Observer;
import util.Location;
import util.Vector;


public class Turtle extends Observable {

    public static final int UP_DIRECTION = 90;
    public static final Location INITIAL_COORDINATE = new Location(0, 0);

    private Observer myObserver;
    private Location myLocation;
    private double myHeading;
    private boolean myPenDown;
    private boolean myVisible;

    public Turtle (Observer observer) {
        myObserver = observer;
        addObserver(myObserver);
        setLocation(INITIAL_COORDINATE);
        setHeading(UP_DIRECTION);
        setPenDown(false);
        setVisible(true);
    }

    public void rotate (double degrees) {
        myHeading = myHeading + degrees;
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
        notifyObservers(this);
    }

}
