package frontEnd;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Set;
import util.Location;
import util.Trail;


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
    protected int myTurtleIndex;

    /**
     * Draws the Body of the turtle. Different implementations include a filled triangle,
     * an outline triangle, and an image of a turtle.
     * 
     * @param pen - Graphics tool
     * @param start - Beginning Location of Turtle
     * @param finish - next Location of Turtle
     * @param heading - current Turtle heading
     */
    public abstract void drawBody (Graphics pen, double heading);

    /**
     * Adds a pair of trail points to the Trail List.
     * 
     * @param start - initial point
     * @param finish - destination point
     */
    public abstract void addTrail (Location start, Location finish, Graphics pen);

    /**
     * Returns the Trail List.
     * 
     * @return List<Trail>
     */
    public abstract List<Trail> getTrail ();

    /**
     * clears all Trails from the trail list. Included here not because implementation will
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
     * Returns all references to other TurtleDrawers
     * 
     * @return Set of referenced TurtleDrawers.
     */
    public abstract Set<TurtleDrawer> getReferences ();

    /**
     * Remove the given type of turtleDrawer from the set of references.
     * 
     * @param turtleDrawer
     * @return TurtleDrawer that no longer contains the reference.
     */
    public abstract TurtleDrawer removeReference (TurtleDrawer turtleDrawer);

    /**
     * Makes it so that all instantiations of a certain subclass of TurtleDrawer are equal.
     * Important for sets and .equals statements when removing and adding references.
     */
    @Override
    public int hashCode () {
        return this.getClass().getName().hashCode();
    }

    /**
     * Returns whether or not a TurtleDrawer object is the same subclass as an other TurtleDrawer
     * object.
     * 
     * Makes it so that all instantiations of a certain subclass of TurtleDrawer are equal.
     * Important for sets and .equals statements when removing and adding references.
     */
    @Override
    public boolean equals (Object o) {
        if (o.getClass().equals(this.getClass())) { return (this.hashCode() == o.hashCode()); }
        return false;
    }

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

    protected int getTurtleIndex () {
        return myTurtleIndex;
    }

    protected void setTurtleIndex (int turtleIndex) {
        myTurtleIndex = turtleIndex;
    }

    /**
     * Calls translateCoordinates method in the view.
     * 
     * @param point
     * @return translated coordinate point
     */
    protected Location translateCoordinates (Location point) {
        return getView().translateCoordinates(point);
    }

    /**
     * Returns the bounds of the view.
     * 
     * @return
     */
    protected Rectangle getBounds () {
        return getView().getBounds();
    }
}
