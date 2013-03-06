package frontEnd;

import java.awt.Graphics;
import java.util.Set;
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
    public void clearTrail () {
        myReferenceDrawer.clearTrail();
    }

    @Override
    public void addTrail (Location start, Location finish) {
        myReferenceDrawer.addTrail(start, finish);
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

    public TurtleDrawer removeReference(TurtleDrawer turtleDrawer){
        if(this.equals(turtleDrawer)){
            return myReferenceDrawer;
        }
        else{
            myReferenceDrawer.removeReference(turtleDrawer);
            return this;
        }
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
