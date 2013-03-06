package frontEnd;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.Location;
import util.Vector;


/**
 * Default Implementation of TurtleDrawer. The Simple Branch of the hierarchy (No decorations).
 * Draws an unfilled triangle for the body, solid lines for the trail, and does not implement
 * warping functionality.
 * 
 * @author Danny Goodman
 * 
 */
public class DefaultTurtleDrawer extends TurtleDrawer {

    private static final int TURTLE_HEIGHT = 30;
    private static final double TURTLE_ANGLE_1 = 40;
    private static final double TRIANGLE_DEGREES = 180;
    private static final double RIGHT_ANGLE = 90;
    private static final double TURTLE_ANGLE_2 = (180 - TURTLE_ANGLE_1) / 2;
    protected List<Location> myTrailPoints;

    /**
     * Initialize trailPoints and set the view.
     * 
     * @param view - TurtleView
     */
    public DefaultTurtleDrawer (TurtleView view) {
        myTrailPoints = new ArrayList<Location>();
        setView(view);
    }

    @Override
    public void drawBody (Graphics pen, Location start, Location finish, double heading) {
        Vector centerToHead = new Vector(heading, TURTLE_HEIGHT * 2 / 3);
        Vector headToLeft = new Vector(heading - (TRIANGLE_DEGREES - (TURTLE_ANGLE_1 / 2)),
                                       TURTLE_HEIGHT / Math.sin(Math.toRadians(TURTLE_ANGLE_2)));
        Vector leftToRight =
                new Vector(heading + RIGHT_ANGLE,
                           2 * TURTLE_HEIGHT / Math.tan(Math.toRadians(TURTLE_ANGLE_2)));
        Location vertex = new Location(finish.getX() + centerToHead.getXChange(),
                                       finish.getY() + centerToHead.getYChange());
        Location leftPoint = new Location(vertex.getX() + headToLeft.getXChange(),
                                          vertex.getY() + headToLeft.getYChange());
        Location rightPoint = new Location(leftPoint.getX() + leftToRight.getXChange(),
                                           leftPoint.getY() + leftToRight.getYChange());
        drawLine(pen, vertex, leftPoint);
        drawLine(pen, leftPoint, rightPoint);
        drawLine(pen, rightPoint, vertex);
    }

    @Override
    public void addTrail (Location start, Location finish) {
        myTrailPoints.add(new Location(start));
        myTrailPoints.add(new Location(finish));
    }

    @Override
    public void clearTrail () {
        myTrailPoints = new ArrayList<Location>();
    }

    @Override
    public void drawTrail (Graphics pen) {
        for (int i = 0; i < myTrailPoints.size() - 1; i += 2) {
            if ((!isOutsideBounds(myTrailPoints.get(i))) ||        // if statement prevents
                (!isOutsideBounds(myTrailPoints.get(i + 1)))) {    // unnecessary drawing
                drawLine(pen, myTrailPoints.get(i), myTrailPoints.get(i + 1));
            }
        }
    }

    @Override
    public Set<TurtleDrawer> getReferences () {
        Set<TurtleDrawer> turtleDrawerSet = new HashSet<TurtleDrawer>();
        turtleDrawerSet.add(this);
        return turtleDrawerSet;
    }

    @Override
    public TurtleDrawer removeReference (TurtleDrawer turtleDrawer) {
        return this;
    }

    /**
     * Draws Line from Location start to finish
     * 
     * @param pen - Graphics tool
     * @param start - Begin Location
     * @param finish - End Location
     */
    protected void drawLine (Graphics pen, Location start, Location finish) {
        start = getView().translateCoordinates(start);
        finish = getView().translateCoordinates(finish);
        pen.drawLine((int) start.getX(), (int) start.getY(),
                     (int) finish.getX(), (int) finish.getY());
    }

}
