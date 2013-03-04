package frontEnd;

import java.awt.Graphics;
import util.Location;

public abstract class DecoratedTurtleDrawer extends TurtleDrawer{

    private TurtleDrawer myReferenceDrawer;
    
    public DecoratedTurtleDrawer(TurtleDrawer referenceDrawer){
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
    
    protected TurtleDrawer getReference(){
        return myReferenceDrawer;
    }
    

}
