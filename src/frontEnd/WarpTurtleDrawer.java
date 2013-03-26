package frontEnd;

import java.awt.Graphics;
import java.util.List;
import util.Location;
import util.Trail;
import util.WarpedTrail;


/**
 * Warping subclass of DecoratedTurtleDrawer.
 * 
 * @author Danny Goodman
 * 
 */
public class WarpTurtleDrawer extends DecoratedTurtleDrawer {

    private int[] myWarpTotals; // [left][bottom][right][top]

    /**
     * Calls superclass constructor. Initializes myWarpTotals.
     * 
     * @param referenceDrawer
     */
    public WarpTurtleDrawer (TurtleDrawer referenceDrawer) {
        super(referenceDrawer);
        int id = getTurtleIndex();
        myWarpTotals = new int[] { 0, 0, 0, 0 };
        initTrailWarps();
        getView().setTurtleWarps(id, sumWarps(myWarpTotals, getView().getTurtleWarps(id)));
        myWarpTotals = getView().getTurtleWarps(id);
    }
    
    public WarpTurtleDrawer (){
        super();
    }

    /**
     * Creates a new WarpedTrail object from the start and finish Locations and adds it to the
     * TrailList. Adds its warps to the myWarpTotals.
     */
    @Override
    public void addTrail (Location start, Location finish, Graphics pen) {
        Trail currentTrail = new WarpedTrail(start, finish, pen.getColor(), getBounds());
        getTrail().add(currentTrail);
        addToWarps(currentTrail.getWarps());
    }

    // Initialize trail warps by converting all Trail objects in TrailList to WarpedTrail objects.
    private void initTrailWarps () {
        List<Trail> trailList = getTrail();
        for (int i = 0; i < trailList.size(); i++) {
            trailList.set(i, getView().calculateWarps(trailList.get(i), myWarpTotals).warp());
            myWarpTotals = sumWarps(myWarpTotals, trailList.get(i).getWarps());
        }
    }

    // Adds given int[] to myWarpTotals.
    private void addToWarps (int[] addWarps) {
        for (int i = 0; i < addWarps.length; i++) {
            myWarpTotals[i] += addWarps[i];
        }
    }

    // adds to warps int[]'s together and returns the sum.
    private int[] sumWarps (int[] myWarps, int[] addWarps) {
        int[] sumWarps = new int[] { 0, 0, 0, 0 };
        for (int i = 0; i < myWarps.length; i++) {
            sumWarps[i] = myWarps[i] + addWarps[i];
        }
        return sumWarps;
    }

}
