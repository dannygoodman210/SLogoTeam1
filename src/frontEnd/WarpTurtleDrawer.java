package frontEnd;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import util.Location;
import util.Trail;
import util.WarpWall;
import util.WarpedTrail;


/**
 * Warping subclass of TurtleDrawer decorator.
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
        myWarpTotals = new int[] { 0, 0, 0, 0 };
        initTrailWarps();
        getView().setTurtleWarps(sumWarps(myWarpTotals, getView().getTurtleWarps()));
        myWarpTotals = getView().getTurtleWarps();
    }

    @Override
    public void addTrail (Location start, Location finish, Graphics pen) {
        Trail currentTrail = new WarpedTrail(start, finish, pen.getColor(), getBounds());
        getTrail().add(currentTrail);
        addToWarps(currentTrail.getWarps());
    }

    @Override
    public TurtleDrawer removeReference (TurtleDrawer turtleDrawer) {
        return super.removeReference(turtleDrawer);
    }

    private void initTrailWarps () {
        List<Trail> trailList = getTrail();
        for (int i = 0; i < trailList.size(); i++) {
            trailList.set(i, getView().calculateWarps(trailList.get(i),myWarpTotals).warp());
            myWarpTotals = sumWarps(myWarpTotals,trailList.get(i).getWarps());
        }
    }

    private void addToWarps (int[] addWarps) {
        for (int i = 0; i < addWarps.length; i++) {
            myWarpTotals[i] += addWarps[i];
        }
    }

    private int[] sumWarps (int[] myWarps, int[] addWarps) {
        int[] sumWarps = new int[] { 0, 0, 0, 0 };
        for (int i = 0; i < myWarps.length; i++) {
            sumWarps[i] = myWarps[i] + addWarps[i];
        }
        return sumWarps;
    }

}
