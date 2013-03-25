package frontEnd;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.Location;
import util.Trail;
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
    protected List<Trail> myTrailList;

    /**
     * Initialize trailPoints and set the view.
     * 
     * @param view - TurtleView
     */
    public DefaultTurtleDrawer (TurtleView view, int turtleIndex) {
        myTrailList = new ArrayList<Trail>();
        setView(view);
        setTurtleIndex(turtleIndex);
    }

    /**
     * Implements an unfilled Triangle body.
     */
    @Override
    public void drawBody (Graphics pen, double heading) {
        Location center = getTrail().get(getTrail().size() - 1).getEnd();
        Vector centerToHead = new Vector(heading, TURTLE_HEIGHT * 2 / 3);
        Vector headToLeft = new Vector(heading - (TRIANGLE_DEGREES - (TURTLE_ANGLE_1 / 2)),
                                       TURTLE_HEIGHT / Math.sin(Math.toRadians(TURTLE_ANGLE_2)));
        Vector leftToRight =
                new Vector(heading + RIGHT_ANGLE,
                           2 * TURTLE_HEIGHT / Math.tan(Math.toRadians(TURTLE_ANGLE_2)));
        Location vertex = new Location(center.getX() + centerToHead.getXChange(),
                                       center.getY() + centerToHead.getYChange());
        Location leftPoint = new Location(vertex.getX() + headToLeft.getXChange(),
                                          vertex.getY() + headToLeft.getYChange());
        Location rightPoint = new Location(leftPoint.getX() + leftToRight.getXChange(),
                                           leftPoint.getY() + leftToRight.getYChange());
        drawLine(pen, vertex, leftPoint);
        drawLine(pen, leftPoint, rightPoint);
        drawLine(pen, rightPoint, vertex);
    }

    /**
     * Creates a new Trail object from the start and finish Locations and adds it to the TrailList.
     */
    @Override
    public void addTrail (Location start, Location finish, Graphics pen) {
        myTrailList.add(new Trail(start, finish, pen.getColor(), getBounds()));
    }

    @Override
    public List<Trail> getTrail () {
        return myTrailList;
    }

    @Override
    public void clearTrail () {
        myTrailList = new ArrayList<Trail>();
    }

    /**
     * Iterates through Trails in TrailList and calls their paint method.
     */
    @Override
    public void drawTrail (Graphics pen) {
        for (int i = 0; i < myTrailList.size(); i++) {
            myTrailList.get(i).paint(pen);
        }
    }

    /**
     * returns a Set containing only this object. DefaultTurtleDrawer contains no references.
     */
    @Override
    public Set<TurtleDrawer> getReferences () {
        Set<TurtleDrawer> turtleDrawerSet = new HashSet<TurtleDrawer>();
        turtleDrawerSet.add(this);
        return turtleDrawerSet;
    }

    /**
     * DefaultTurtleDrawer cannot remove references. Returns itself.
     */
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
        start = translateCoordinates(start);
        finish = translateCoordinates(finish);
        pen.drawLine((int) start.getX(), (int) start.getY(),
                     (int) finish.getX(), (int) finish.getY());
    }

}
