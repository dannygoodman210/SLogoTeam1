package util;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


/**
 * Enumerated Class to handle warping about each wall of the rectangular bounds.
 * 
 * @author Danny Goodman
 * 
 */
public enum WarpWall {
    NONE(0) {

        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            return getList(outOfBounds, outOfBounds, outOfBounds);
        }

    },
    LEFT(1) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            double left = -bounds.getWidth() / 2;
            Vector between = new Vector(inBounds, outOfBounds);
            Location intersectPoint =
                    new Location(left, inBounds.getY() + ((left - inBounds.getX()) *
                                       Math.tan(Math.toRadians(between.getDirection()))));
            Location start = new Location(-left, intersectPoint.getY());
            Location end = new Location(start);
            between.difference(new Vector(inBounds, intersectPoint));
            end.translate(between);
            return getList(intersectPoint, start, end);
        }

    },
    TOP(2) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            double top = bounds.getHeight() / 2;
            Vector between = new Vector(inBounds, outOfBounds);
            Location intersectPoint =
                    new Location(inBounds.getX() + ((top - inBounds.getY()) /
                                 Math.tan(Math.toRadians(between.getDirection()))), top);
            Location start = new Location(intersectPoint.getX(), -top);
            Location end = new Location(start);
            between.difference(new Vector(inBounds, intersectPoint));
            end.translate(between);
            return getList(intersectPoint, start, end);
        }

    },
    TOPLEFT(3) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            List<Location> listFirst = new ArrayList<Location>();
            List<Location> listSecond = new ArrayList<Location>();
            Location corner = new Location(-bounds.getWidth() / 2, bounds.getHeight() / 2);
            Vector between = new Vector(inBounds, outOfBounds);
            Vector toCorner = new Vector(inBounds, corner);
            if (between.getDirection() > toCorner.getDirection()) {
                listFirst = WarpWall.LEFT.warp(inBounds, outOfBounds, bounds);
                listSecond = WarpWall.TOP.warp(listFirst.get(1), listFirst.get(2), bounds);
            }
            else {
                listFirst = WarpWall.TOP.warp(inBounds, outOfBounds, bounds);
                listSecond = WarpWall.LEFT.warp(listFirst.get(1), listFirst.get(2), bounds);
            }
            return getList(listFirst.get(0), listFirst.get(1),
                           listSecond.get(0), listSecond.get(1), listSecond.get(2));
        }

    },
    RIGHT(4) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            double right = bounds.getWidth() / 2;
            Vector between = new Vector(inBounds, outOfBounds);
            Location intersectPoint =
                    new Location(right, inBounds.getY() + ((right - inBounds.getX()) *
                                        Math.tan(Math.toRadians(between.getDirection()))));
            Location start = new Location(-right, intersectPoint.getY());
            Location end = new Location(start);
            between.difference(new Vector(inBounds, intersectPoint));
            end.translate(between);
            return getList(intersectPoint, start, end);
        }

    },
    TOPRIGHT(6) {

        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            List<Location> listFirst = new ArrayList<Location>();
            List<Location> listSecond = new ArrayList<Location>();
            Location corner = new Location(bounds.getWidth() / 2, bounds.getHeight() / 2);
            Vector between = new Vector(inBounds, outOfBounds);
            Vector toCorner = new Vector(inBounds, corner);
            if (between.getDirection() > toCorner.getDirection()) {
                listFirst = WarpWall.TOP.warp(inBounds, outOfBounds, bounds);
                listSecond = WarpWall.RIGHT.warp(listFirst.get(1), listFirst.get(2), bounds);
            }
            else {
                listFirst = WarpWall.RIGHT.warp(inBounds, outOfBounds, bounds);
                listSecond = WarpWall.TOP.warp(listFirst.get(1), listFirst.get(2), bounds);
            }
            return getList(listFirst.get(0), listFirst.get(1),
                           listSecond.get(0), listSecond.get(1), listSecond.get(2));
        }

    },
    BOTTOM(8) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            double bottom = -bounds.getHeight() / 2;
            Vector between = new Vector(inBounds, outOfBounds);
            Location intersectPoint =
                    new Location(inBounds.getX() + ((bottom - inBounds.getY()) /
                                 Math.tan(Math.toRadians(between.getDirection()))), bottom);
            Location start = new Location(intersectPoint.getX(), -bottom);
            Location end = new Location(start);
            between.difference(new Vector(inBounds, intersectPoint));
            end.translate(between);
            return getList(intersectPoint, start, end);
        }

    },
    BOTTOMLEFT(9) {

        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            List<Location> listFirst = new ArrayList<Location>();
            List<Location> listSecond = new ArrayList<Location>();
            Location corner = new Location(-bounds.getWidth() / 2, -bounds.getHeight() / 2);
            Vector between = new Vector(inBounds, outOfBounds);
            Vector toCorner = new Vector(inBounds, corner);
            if (between.getDirection() > toCorner.getDirection()) {
                listFirst = WarpWall.BOTTOM.warp(inBounds, outOfBounds, bounds);
                listSecond = WarpWall.LEFT.warp(listFirst.get(1), listFirst.get(2), bounds);
            }
            else {
                listFirst = WarpWall.LEFT.warp(inBounds, outOfBounds, bounds);
                listSecond = WarpWall.BOTTOM.warp(listFirst.get(1), listFirst.get(2), bounds);
            }
            return getList(listFirst.get(0), listFirst.get(1),
                           listSecond.get(0), listSecond.get(1), listSecond.get(2));
        }

    },
    BOTTOMRIGHT(12) {

        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            List<Location> listFirst = new ArrayList<Location>();
            List<Location> listSecond = new ArrayList<Location>();
            Location corner = new Location(-bounds.getWidth() / 2, bounds.getHeight() / 2);
            Vector between = new Vector(inBounds, outOfBounds);
            Vector toCorner = new Vector(inBounds, corner);
            if (between.getDirection() > toCorner.getDirection()) {
                listFirst = WarpWall.RIGHT.warp(inBounds, outOfBounds, bounds);
                listSecond = WarpWall.BOTTOM.warp(listFirst.get(1), listFirst.get(2), bounds);
            }
            else {
                listFirst = WarpWall.BOTTOM.warp(inBounds, outOfBounds, bounds);
                listSecond = WarpWall.RIGHT.warp(listFirst.get(1), listFirst.get(2), bounds);
            }
            return getList(listFirst.get(0), listFirst.get(1),
                           listSecond.get(0), listSecond.get(1), listSecond.get(2));
        }

    };

    private int value;

    private WarpWall (int value) {
        this.value = value;
    }

    /**
     * Returns the value of the wall. These values are derived from the binary representation of
     * the wall.
     * 
     * @return value - binary representation of wall.
     */
    public int getValue () {
        return value;
    }

    /**
     * Handles Calculation of Trail points for a given path from inside the bounds to outside
     * of the bounds. Each wall has a different implementation.
     * 
     * @param inBounds - Location within the bounds.
     * @param outOfBounds - Location outside of the bounds.
     * @param bounds - Rectangle representing bounds of the view.
     * @return List<Location> - list of Locations that make up the trail.
     */
    public abstract List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds);

    /**
     * returns a list of the given Location objects. Cleans up the warp method. This method
     * signature contains three Location inputs. This signature is called by the side WallWarps:
     * LEFT, TOP, RIGHT, and BOTTOM.
     * 
     * @param intersectPoint - where path first intersects bounds
     * @param start - point after warp
     * @param end - end Location
     * @return ArrayList of Locations
     */
    protected List<Location> getList (Location intersectPoint, Location start, Location end) {
        List<Location> pointsList = new ArrayList<Location>();
        pointsList.add(intersectPoint);
        pointsList.add(start);
        pointsList.add(end);
        return pointsList;
    }

    /**
     * Returns a list of the given Location objects. Cleans up the warp method. This method
     * signature contains five Location inputs. This signature is called by the corner WallWarps:
     * TOPLEFT, TOPRIGHT, BOTTOMLEFT, and BOTTOMRIGHT.
     * 
     * @param intersect1 - where path first intersects bounds
     * @param start1 - Location after first warp
     * @param intersect2 - where path intersects bounds second
     * @param start2 - Location after second warp
     * @param end - end Location
     * @return ArrayList of Locations
     */
    protected List<Location> getList (Location intersect1, Location start1,
                                      Location intersect2, Location start2, Location end) {
        List<Location> pointsList = new ArrayList<Location>();
        pointsList.add(intersect1);
        pointsList.add(start1);
        pointsList.add(intersect2);
        pointsList.add(start2);
        pointsList.add(end);
        return pointsList;
    }

}
