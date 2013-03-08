package frontEnd;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
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
        myWarpTotals = new int[]{0, 0, 0, 0};
        initTrailWarps();
        getView().setTurtleWarps(addWarps(myWarpTotals,getView().getTurtleWarps()));
        myWarpTotals = getView().getTurtleWarps();
    }

    @Override
    public void addTrail (Location start, Location finish) {
        System.out.println("add Trails.");
        // finish = new Location(calculateWarps(finish));
        if (!isOutsideBounds(finish)) {
            super.addTrail(start, finish);
        }
        while (isOutsideBounds(finish)) {
            System.out.println(start + " " + finish);
            List<Location> list = warpPath(start, finish);
            System.out.println("added0: " + start + " " + list.get(0));
            super.addTrail(start, list.get(0));
            finish = list.get(list.size() - 2);
            start = list.get(list.size() - 3);
        }
        System.out.println("added: " + start + " " + finish);
        super.addTrail(start, finish);

    }

    @Override
    public void drawBody (Graphics pen, Location start, Location finish, double heading) {
        System.out.println("drawBody.");
        // finish = calculateWarps(finish);
        while (isOutsideBounds(finish)) {
            finish = warpPosition(start, finish);
        }
        super.drawBody(pen, start, finish, heading);
    }

    @Override
    public TurtleDrawer removeReference (TurtleDrawer turtleDrawer) {
        return super.removeReference(turtleDrawer);
    }

    private void initTrailWarps () {
        System.out.println("init");
        List<Location> trailPoints = getTrail();
        List<Location> warpedPoints = new ArrayList<Location>(trailPoints);
        System.out.println(trailPoints);
        int i = 0;
        while (i < warpedPoints.size() - 1) {
            warpedPoints.set(i, calculateWarps(warpedPoints.get(i)));
            warpedPoints.set(i + 1, calculateWarps(warpedPoints.get(i + 1)));
            System.out.println(i + ": " + warpedPoints);
            Location start = warpedPoints.get(i);
            Location end = warpedPoints.get(i + 1);
            while (isOutsideBounds(end)) {
                System.out.println(i + ":loop: " + warpedPoints);
                end = warpedPoints.remove(i + 1);
                List<Location> pointWarp = warpPath(start, end);
                addToWarps(pointWarp);
                warpedPoints.addAll(i + 1, pointWarp);
                System.out.println(pointWarp);
                i += (pointWarp.size() - 1);
            }
            i += 2;
        }
        System.out.println(warpedPoints);
        setTrail(warpedPoints);
    }

    private Location warpPosition (Location inBounds, Location outOfBounds) {
        System.out.println("warpPosition");
        List<Location> pointsList = warpPath(inBounds, outOfBounds);
        addToWarps(pointsList);
        return pointsList.get(pointsList.size() - 1);
    }
    
    private List<Location> warpPath (Location inBounds, Location outOfBounds) {
        System.out.println("warpPath");
        WarpWall warper = determineWarpWall(inBounds, outOfBounds);
        List<Location> pointsList = warper.warp(inBounds, outOfBounds, getBounds());
        return pointsList;
    }

    private WarpWall determineWarpWall (Location inBounds, Location outOfBounds) {
        Rectangle bounds = getBounds();
        Location translatedPoint = translateCoordinates(outOfBounds);
        int wallValue = bounds.outcode(translatedPoint);
        WarpWall warper = WarpWall.NONE;
        for (WarpWall w : WarpWall.values()) {
            if (w.getWallID() == wallValue) {
                warper = w;
            }
        }
        return warper;
    }

    private void addToWarps (List<Location> pointsList) {
        int value = (int) pointsList.remove(pointsList.size()-1).getX();
        char[] c = Integer.toBinaryString(value).toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            myWarpTotals[Math.abs(i - (c.length - 1) + myWarpTotals.length) % myWarpTotals.length] +=
                    Character.getNumericValue(c[i]);
        }
    }

    private Location calculateWarps (Location location) {
        return getView().calculateWarps(location,myWarpTotals);
    }
    
    private int[] addWarps (int[] myWarps, int[] addWarps) {
        int[] sumWarps = new int[] { 0, 0, 0, 0 };
        for (int i = 0; i < myWarps.length; i++) {
            sumWarps[i] = myWarps[i] + addWarps[i];
        }
        return sumWarps;
    }

}
