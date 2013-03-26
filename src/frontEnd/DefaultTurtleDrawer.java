package frontEnd;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.Location;
import util.Shape;
import util.ShapePalette;
import util.Trail;


/**
 * Default Implementation of TurtleDrawer. The Simple Branch of the hierarchy (No decorations).
 * Draws an unfilled triangle for the body, solid lines for the trail, and does not implement
 * warping functionality.
 * 
 * @author Danny Goodman
 * 
 */
public class DefaultTurtleDrawer extends TurtleDrawer {

    private ShapePalette myShapePalette;
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
        myShapePalette = new ShapePalette();
    }

    /**
     * Implements an unfilled Triangle body.
     */
    @Override
    public void drawBody (Graphics2D pen, double heading, int shapeIndex) {
        Location center = getTrail().get(getTrail().size() - 1).getEnd();
        center = translateCoordinates(center);
        Shape body = getShape(shapeIndex);
        body.paint(pen, center, heading);
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

    @Override
    public Shape getShape (int shapeIndex) {
        return myShapePalette.getShape(shapeIndex);
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
