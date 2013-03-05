package frontEnd;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import util.Location;
import util.Vector;
import util.WarpWall;


/**
 * Warping subclass of TurtleDrawer decorator.
 * 
 * @author Danny Goodman
 * 
 */
public class WarpTurtleDrawer extends DecoratedTurtleDrawer {

    private int[] myWarpTotals; // [left][bottom][right][top]

    public WarpTurtleDrawer (TurtleDrawer referenceDrawer) {
        super(referenceDrawer);
        myWarpTotals = new int[] { 0, 0, 0, 0 };
    }

    @Override
    public void addTrail (Location start, Location finish) {
        finish = new Location(calculateWarps(finish));
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
    public Location drawBody (Graphics pen, Location start, Location finish, double heading) {
        finish = calculateWarps(finish);
        while (isOutsideBounds(finish)) {
            finish = warpPosition(start, finish);
        }
        return super.drawBody(pen, start, finish, heading);
    }

    @Override
    public void reset () {
        resetWarps();
        super.reset();
    }

    private boolean isOutsideBounds (Location point) {
        Location translatedPoint = getView().translateCoordinates(point);
        return !getView().getBounds().contains(translatedPoint);
    }

    private List<Location> warpTrails (Location inBounds, Location outOfBounds) {
        WarpWall warper = determineWarpWall(inBounds, outOfBounds);
        List<Location> pointsList;
        pointsList = warper.warp(inBounds, outOfBounds, getView().getBounds());
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

    private Location calculateWarps (Location point) {
        for (int i = 0; i < myWarpTotals.length; i++) {
            double size = 0;
            if (i % 2 == 0)
                size = getView().getBounds().getWidth();
            else size = getView().getBounds().getHeight();
            Vector v = new Vector(i * 90, myWarpTotals[i] * size);
            point.translate(v);
        }
        return point;
    }

    private void addToWarps (Integer value) {
        char[] c = Integer.toBinaryString(value).toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            myWarpTotals[Math.abs(i - (c.length - 1) + myWarpTotals.length) % myWarpTotals.length] +=
                    Character.getNumericValue(c[i]);
        }
    }

    private void resetWarps () {
        myWarpTotals = new int[] { 0, 0, 0, 0 };
    }

}
