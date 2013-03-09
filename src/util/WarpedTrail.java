package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


/**
 * WarpedTrail class extends Trail class. Calculates warps necessary to trail from the start point
 * to the end point. Uses the WarpWall utility. Keeps track of warps in each direction in a 4
 * element
 * int array, myWarps. Stores all in between points in List<Location> myIntersectPoints. Redefines
 * the
 * way that WarpedTrail is painted in comparison to the Trail superclass.
 * 
 * @author Danny Goodman
 * 
 */
public class WarpedTrail extends Trail {

    private List<Location> myIntersectPoints;
    private int[] myWarps;

    /**
     * Constructor calls superclass constructor. initializes myWarps and calls setIntersectPoints to
     * run the calculations of the intersect points.
     * 
     * @param start - Location
     * @param end - Location
     * @param penColor - color to paint this trail
     * @param bounds - bounds of TurtleView
     */
    public WarpedTrail (Location start, Location end, Color penColor, Rectangle bounds) {
        super(start, end, penColor, bounds);
        myWarps = new int[] { 0, 0, 0, 0 };
        setIntersectPoints();
    }

    /**
     * Overrides paint method from superclass. paints each line segment characterized by myStart,
     * myIntersectPoints, and myEnd.
     */
    @Override
    public void paint (Graphics pen) {
        if (myIntersectPoints.isEmpty()) {
            super.paint(pen);
        }
        else {
            pen.setColor(myColor);
            drawLine(pen, myStart, myIntersectPoints.get(0));
            for (int i = 1; i < myIntersectPoints.size() - 2; i += 2) {
                drawLine(pen, myIntersectPoints.get(i), myIntersectPoints.get(i + 1));
            }
            drawLine(pen, myIntersectPoints.get(myIntersectPoints.size() - 1), myEnd);
        }
    }

    /**
     * Overrides warp method from superclass. resets myWarps so that they are not added to the
     * TurtleDrawer (and thus the TurtleView) twice. returns this, already warped trail.
     */
    @Override
    public Trail warp () {
        myWarps = new int[] { 0, 0, 0, 0 };
        return this;
    }

    /**
     * Returns the warp totals in each direction that this trail object has undergone.
     */
    @Override
    public int[] getWarps () {
        return myWarps;
    }

    // calculate warps using recursive calls to the WallWarp enum.
    private void setIntersectPoints () {
        myIntersectPoints = new ArrayList<Location>();
        Location start = myStart;
        while (isOutsideBounds(myEnd)) {
            List<Location> list = warpPath(start, myEnd);
            addToWarps(list);
            myIntersectPoints.add(list.get(0));
            myIntersectPoints.add(list.get(1));
            start = list.get(1);
            myEnd = list.get(2);
        }
    }

    private List<Location> warpPath (Location start, Location end) {
        WarpWall warper = determineWarpWall(start, end);
        return warper.warp(start, end, myBounds);
    }

    // adds to warps by taking in the WallID, stored in the last element of the list returned by
    // the WarpWall. This WallID contains binary encoding to signify which wall was warped across.
    private void addToWarps (List<Location> pointsList) {
        int value = (int) pointsList.remove(pointsList.size() - 1).getX();
        char[] c = Integer.toBinaryString(value).toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            myWarps[Math.abs(i - (c.length - 1) + myWarps.length) % myWarps.length] +=
                    Character.getNumericValue(c[i]);
        }
    }

    // uses bounds.outcode method that returns a binary value encoding which side the point is
    // outside of the bounds. WallWarp uses this same encoding for its WallID.
    private WarpWall determineWarpWall (Location inBounds, Location outOfBounds) {
        Location translatedPoint = translateCoordinates(outOfBounds);
        int wallValue = myBounds.outcode(translatedPoint);
        WarpWall warper = WarpWall.NONE;
        for (WarpWall w : WarpWall.values()) {
            if (w.getWallID() == wallValue) {
                warper = w;
            }
        }
        return warper;
    }

    private boolean isOutsideBounds (Location point) {
        Location translatedPoint = translateCoordinates(point);
        return !myBounds.contains(translatedPoint);
    }

}
