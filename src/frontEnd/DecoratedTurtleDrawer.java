package frontEnd;

import java.awt.Graphics;
import java.util.List;
import java.util.Set;
import util.Location;
import util.Trail;


/**
 * Abstract Class extends TurtleDrawer. Superclass of all decorators on this side of the
 * TurtleDrawer hierarchy.
 * 
 * @author Danny Goodman
 * 
 */
public abstract class DecoratedTurtleDrawer extends TurtleDrawer {

    private TurtleDrawer myReferenceDrawer;

    /**
     * sets the reference to the TurtleDrawer that is passed in. sets the view to the same as the
     * reference's view.
     * 
     * @param referenceDrawer - referenced TurtleDrawer
     */
    public DecoratedTurtleDrawer (TurtleDrawer referenceDrawer) {
        myReferenceDrawer = referenceDrawer;
        setView(referenceDrawer.getView());
    }

    @Override
    public void drawBody (Graphics pen, double heading) {
        myReferenceDrawer.drawBody(pen, heading);
    }

    @Override
    public void addTrail (Location start, Location finish, Graphics pen) {
        myReferenceDrawer.addTrail(start, finish, pen);
    }

    @Override
    public List<Trail> getTrail () {
        return myReferenceDrawer.getTrail();
    }

    @Override
    public void clearTrail () {
        myReferenceDrawer.clearTrail();
    }

    @Override
    public void drawTrail (Graphics pen) {
        myReferenceDrawer.drawTrail(pen);
    }

    @Override
    public Set<TurtleDrawer> getReferences () {
        Set<TurtleDrawer> turtleDrawerSet = myReferenceDrawer.getReferences();
        turtleDrawerSet.add(this);
        return turtleDrawerSet;
    }

    /**
     * If this object equals the reference to remove, return the reference of this object, thus
     * removing this object node from the reference tree. Else call removeReference on
     * myReferenceDrawer.
     */
    @Override
    public TurtleDrawer removeReference (TurtleDrawer turtleDrawer) {
        if (this.equals(turtleDrawer)) {
            return myReferenceDrawer;
        }
        else {
            myReferenceDrawer.removeReference(turtleDrawer);
            return this;
        }
    }

    /**
     * Returns the reference for this decorator.
     * 
     * @return myReferenceDrawer
     */
    protected TurtleDrawer getReference () {
        return myReferenceDrawer;
    }

}
