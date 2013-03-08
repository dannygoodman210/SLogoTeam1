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
            return generatePointsList(outOfBounds);
        }

    },
    LEFT(1) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            double left = -bounds.getWidth() / 2;
            return leftRightWarp(inBounds, outOfBounds, left);
        }

    },
    TOP(2) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            double top = bounds.getHeight() / 2;
            return topBottomWarp(inBounds, outOfBounds, top);
        }

    },
    LEFT_TOP(3) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            Location corner = new Location(-bounds.getWidth() / 2, bounds.getHeight() / 2);
            return cornerWarp(inBounds, outOfBounds, bounds, corner);
        }

    },
    RIGHT(4) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            double right = bounds.getWidth() / 2;
            return leftRightWarp(inBounds, outOfBounds, right);
        }

    },

    TOP_RIGHT(6) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            Location corner = new Location(bounds.getWidth() / 2, bounds.getHeight() / 2);
            return cornerWarp(inBounds, outOfBounds, bounds, corner);
        }

    },
    BOTTOM(8) {
        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            double bottom = -bounds.getHeight() / 2;
            return topBottomWarp(inBounds, outOfBounds, bottom);
        }

    },
    BOTTOM_LEFT(9) {

        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            Location corner = new Location(-bounds.getWidth() / 2, -bounds.getHeight() / 2);
            return cornerWarp(inBounds, outOfBounds, bounds, corner);
        }

    },
    RIGHT_BOTTOM(12) {

        @Override
        public List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds) {
            Location corner = new Location(-bounds.getWidth() / 2, bounds.getHeight() / 2);
            return cornerWarp(inBounds, outOfBounds, bounds, corner);
        }

    };

    private int myWallID;

    /**
     * Assigns the binaryID to the myWallID instance variable.
     * binaryID is given by: MSB to LSB is BOTTOM, RIGHT, TOP, LEFT.
     * Example: 0010 represents TOP and has an int value of 2.
     * 0011 represents TOP_LEFT and has an int value of 3.
     * 
     * @param binaryID - binary representation of wall.
     * 
     */
    private WarpWall (int binaryID) {
        this.myWallID = binaryID;
    }

    /**
     * Returns the value of the wall. These values are derived from the binary representation of
     * the wall.
     * 
     * @return myWallID - binary representation of wall.
     */
    public int getWallID () {
        return myWallID;
    }

    /**
     * Handles Calculation of Trail points for a given path from inside the bounds to outside
     * of the bounds. Each wall has a different implementation.
     * 
     * @param inBounds - Initial location within the bounds of the view
     * @param outOfBounds - Final unwarped location outside the bounds of the view
     * @param bounds - Rectangle representing bounds of the view.
     * @return List of points that make up the warped trail.
     */
    public abstract List<Location> warp (Location inBounds, Location outOfBounds, Rectangle bounds);

    /**
     * Calculations for a point outside of the bounds on two sides (a corner).
     * 
     * @param inBounds - Initial location within the bounds of the view
     * @param outOfBounds - Final unwarped location outside the bounds of the view
     * @param bounds
     * @param corner
     * @return List of points that represent the warped path
     */
    protected List<Location> cornerWarp (Location inBounds, Location outOfBounds,
                                         Rectangle bounds, Location corner) {
        Vector between = new Vector(inBounds, outOfBounds);
        Vector toCorner = new Vector(inBounds, corner);
        String[] sides = getSides();
        int side = 0; // 0 indicates first side in name while 1 indicates second.
        if (between.getDirection() < toCorner.getDirection()) { // which side it intersects first.
            side = 1;
        }
        try {
            return Enum.valueOf(WarpWall.class, sides[side]).warp(inBounds, outOfBounds, bounds);
        }
        catch (SecurityException | IllegalArgumentException e) {
            // TODO send error to view
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Calculations for a point outside of the bounds on either the left or right side
     * 
     * @param inBounds - Initial location within the bounds of the view
     * @param outOfBounds - Final unwarped location outside the bounds of the view
     * @param side - x value of either left or right side of bounds
     * @return List of points that represent the warped path
     */
    protected List<Location> leftRightWarp (Location inBounds, Location outOfBounds, double side) {
        Vector between = new Vector(inBounds, outOfBounds);
        Location intersectPoint =
                new Location(side, inBounds.getY() + ((side - inBounds.getX()) *
                                   Math.tan(Math.toRadians(between.getDirection()))));
        Location start = new Location(-side, intersectPoint.getY());
        return calculatePointsList(inBounds, intersectPoint, start, between);
    }

    /**
     * Calculations for a point outside of the bounds on either the top or bottom side
     * 
     * @param inBounds - Initial location within the bounds of the view
     * @param outOfBounds - Final unwarped location outside the bounds of the view
     * @param side - y value of either top or bottom side of bounds
     * @return List of points that represent the warped path
     */
    protected List<Location> topBottomWarp (Location inBounds, Location outOfBounds, double side) {
        Vector between = new Vector(inBounds, outOfBounds);
        Location intersectPoint =
                new Location(inBounds.getX() + ((side - inBounds.getY()) /
                             Math.tan(Math.toRadians(between.getDirection()))), side);
        Location start = new Location(intersectPoint.getX(), -side);
        return calculatePointsList(inBounds, intersectPoint, start, between);
    }

    /**
     * Calculates final point to be added to the pointsList. Generates and returns the pointsList
     * object.
     * 
     * @param inBounds - Initial location within the bounds of the view
     * @param intersect - Location where path intersects bounds
     * @param start - Location where path starts after the warp occurs
     * @param between - Vector representing the path from inBounds to the unwarped final Location.
     * @return pointsList containing the intersect, start, and end points.
     */
    protected List<Location> calculatePointsList (Location inBounds, Location intersect,
                                                  Location start, Vector between) {
        Location end = new Location(start);
        between.difference(new Vector(inBounds, intersect));
        end.translate(between);
        return generatePointsList(intersect, start, end);
    }

    /**
     * Create a List of points from any number of points
     * 
     * @param points - Location objects to include in list
     * @return pointsList
     */
    protected List<Location> generatePointsList (Location ... points) {
        List<Location> pointsList = new ArrayList<Location>();
        for (Location p : points) {
            pointsList.add(p);
        }
        pointsList.add(new Location(myWallID, myWallID));
        return pointsList;

    }

    /**
     * Generates a String Array of each side making up the name of the WarpWall
     * field separated by the "_" token. Example: "LEFT_TOP" => ["LEFT","TOP"].
     * 
     * @return String[] of names of associated WarpWall fields
     */
    protected String[] getSides () {
        return this.toString().split("_");
    }

    /**
     * Takes in String Array and flips the first two elements in the array. Used to determine
     * calculations based on which wall was intersected first as the path reached outOfBounds from
     * a corner.
     * 
     * @param sides - String[] of sides of bounds that the path has intersected
     */
    protected void flipSides (String[] sides) {
        String sideTwo = sides[1];
        sides[1] = sides[0];
        sides[0] = sideTwo;
    }

}
