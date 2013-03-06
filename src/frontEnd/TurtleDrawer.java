package frontEnd;

import java.awt.Graphics;
import java.util.Set;
import util.Location;


/**
 * Abstract Class to define a TurtleDrawer. Will have two subclass branches, one being a simple
 * TurtleDrawer and one being a DecoratedTurtleDrawer. The DecoratedTurtleDrawer changes the state
 * or functionality of the TurtleDrawer dynamically. see Decorator Pattern.
 * 
 * @author Danny Goodman
 * 
 */
public abstract class TurtleDrawer {

    private TurtleView myView;

    /**
     * Draws the Body of the turtle. Different implementations include a filled triangle,
     * an outline triangle, and an image of a turtle.
     * 
     * @param pen - Graphics tool
     * @param start - Beginning Location of Turtle
     * @param finish - next Location of Turtle
     * @param heading - current Turtle heading
     * @return Location - next Location. Can be different from what is passed in.
     */
    public abstract Location drawBody (Graphics pen, Location start, Location finish, double heading);

    /**
     * Adds a pair of trail points to the Trail List.
     * 
     * @param start - initial point
     * @param finish - destination point
     */
    public abstract void addTrail (Location start, Location finish);

    /**
     * clears all Locations from the trail list. Included here not because implementation will
     * change, but because the view needs to be able to call this method for any TurtleDrawer from
     * its myTurtleDrawer container of type TurtleDrawer.
     * 
     */
    public abstract void clearTrail ();

    /**
     * Draws the trail from the trail list. can be implemented to draw in different ways with the
     * default being a solid line from point to point.
     * 
     * @param pen - Graphics tool
     */
    public abstract void drawTrail (Graphics pen);

    /**
     * returns all references to other TurtleDrawers
     * 
     * @return Set of referenced TurtleDrawers.
     */
    public abstract Set<TurtleDrawer> getReferences ();

    public abstract TurtleDrawer removeReference (TurtleDrawer turtleDrawer);

    /**
     * Resets instance variables related to TurtleLocation such as the trail points and total warps
     * lists.
     */
    public abstract void reset ();

    /**
     * Returns the view associated with the TurtleDrawer.
     * 
     * @return myView - view associated with TurtleDrawer
     */
    protected TurtleView getView () {
        return myView;
    }

    /**
     * Sets the view associated with the TurtleDrawer. Usually called from the constructor.
     * 
     * @param view - TurtleView
     */
    protected void setView (TurtleView view) {
        myView = view;
    }

    @Override
    public int hashCode () {
        return this.getClass().getName().hashCode();
    }

    @Override
    public boolean equals (Object o) {
        return (this.hashCode() == o.hashCode());
    }

}
