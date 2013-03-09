package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import frontEnd.TurtleView;


public class WarpedTrail extends Trail {

    private List<Location> myIntersectPoints;
    private int[] myWarps;

    public WarpedTrail (Location start, Location end, Color penColor, Rectangle bounds) {
        super(start, end, penColor, bounds);
        myWarps = new int[] { 0, 0, 0, 0 };
        setIntersectPoints();
    }

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

    @Override
    public Trail warp () {
        myWarps = new int[] { 0, 0, 0, 0 };
        return this;
    }

    @Override
    public int[] getWarps () {
        return myWarps;
    }

    public String toString () {
        return "{" + myStart + " " + myIntersectPoints + " " + myEnd + "}";
    }

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

    private void addToWarps (List<Location> pointsList) {
        int value = (int) pointsList.remove(pointsList.size() - 1).getX();
        char[] c = Integer.toBinaryString(value).toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            myWarps[Math.abs(i - (c.length - 1) + myWarps.length) % myWarps.length] +=
                    Character.getNumericValue(c[i]);
        }
    }

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
        translatedPoint.floor();
        return !myBounds.contains(translatedPoint);
    }

}
