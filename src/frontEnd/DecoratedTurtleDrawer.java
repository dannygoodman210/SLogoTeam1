package frontEnd;

import java.awt.Graphics;
import util.Location;


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
    public Location drawBody (Graphics pen, Location start, Location finish, double heading) {
        return myReferenceDrawer.drawBody(pen, start, finish, heading);

    }

    @Override
    public void addTrail (Location start, Location finish) {
        myReferenceDrawer.addTrail(start, finish);

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
    public void reset () {
        myReferenceDrawer.reset();
    }

    /**
     * Returns the reference for this decorator.
     * 
     * @return
     */
    protected TurtleDrawer getReference () {
        return myReferenceDrawer;
    }

}
