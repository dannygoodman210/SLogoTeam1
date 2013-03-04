package frontEnd;

import java.awt.Graphics;
import util.Location;


public abstract class TurtleDrawer {

    private TurtleView myView;

    public abstract Location drawBody (Graphics pen, Location start, Location finish, double heading);

    public abstract void addTrail (Location start, Location finish);

    public abstract void clearTrail ();

    public abstract void drawTrail (Graphics pen);

    protected TurtleView getView () {
        return myView;
    }

    protected void setView (TurtleView view) {
        myView = view;
    }
}
