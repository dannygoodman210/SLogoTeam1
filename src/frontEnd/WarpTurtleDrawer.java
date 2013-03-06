package frontEnd;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import util.Location;
import util.WarpWall;


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
        myWarpTotals = getView().getTurtleWarps();
    }

    @Override
    public void addTrail (Location start, Location finish) {
        // finish = new Location(calculateWarps(finish));
        if (!isOutsideBounds(finish)) {
            super.addTrail(start, finish);
        }
        while (isOutsideBounds(finish)) {
            List<Location> list = warpTrails(start, finish);
            start = list.get(list.size() - 2);
            finish = list.get(list.size() - 1);
        }
    }

    @Override
    public void drawBody (Graphics pen, Location start, Location finish, double heading) {
        // finish = calculateWarps(finish);
        while (isOutsideBounds(finish)) {
            finish = warpPosition(start, finish);
        }
        super.drawBody(pen, start, finish, heading);
    }
    
    @Override
    public TurtleDrawer removeReference (TurtleDrawer turtleDrawer) {
        getView().setTurtleWarps(myWarpTotals);
        return super.removeReference(turtleDrawer);
    }

    private List<Location> warpTrails (Location inBounds, Location outOfBounds) {
        WarpWall warper = determineWarpWall(inBounds, outOfBounds);
        List<Location> pointsList = warper.warp(inBounds, outOfBounds, getView().getBounds());
        super.addTrail(inBounds, pointsList.get(0));
        for (int i = 1; i < pointsList.size() - 1; i += 2) {
            super.addTrail(pointsList.get(i), pointsList.get(i + 1));
        }
        return pointsList;
    }

    private Location warpPosition (Location inBounds, Location outOfBounds) {
        WarpWall warper = determineWarpWall(inBounds, outOfBounds);
        addToWarps(warper.getWallID());
        List<Location> pointsList = warper.warp(inBounds, outOfBounds, getView().getBounds());
        return pointsList.get(pointsList.size() - 1);
    }

    private WarpWall determineWarpWall (Location inBounds, Location outOfBounds) {
        Rectangle bounds = getView().getBounds();
        Location translatedPoint = getView().translateCoordinates(outOfBounds);
        int wallValue = bounds.outcode(translatedPoint);
        WarpWall warper = WarpWall.NONE;
        for (WarpWall w : WarpWall.values()) {
            if (w.getWallID() == wallValue) {
                warper = w;
            }
        }
        return warper;
    }

    private void addToWarps (Integer value) {
        char[] c = Integer.toBinaryString(value).toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            myWarpTotals[Math.abs(i - (c.length - 1) + myWarpTotals.length) % myWarpTotals.length] +=
                    Character.getNumericValue(c[i]);
        }
    }

}