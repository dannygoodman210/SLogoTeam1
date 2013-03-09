package frontEnd;

import java.awt.Color;
import java.awt.Graphics;
import util.Location;
import util.Vector;


/**
 * Extends DecoratedTurtleDrawer. This Decorator paints the turtle as a filled in triangle.
 * 
 * @author Danny Goodman
 * 
 */
public class FilledTurtleDrawer extends DecoratedTurtleDrawer {

    private static final int TURTLE_HEIGHT = 30;
    private static final double TURTLE_ANGLE_1 = 40;
    private static final double TRIANGLE_DEGREES = 180;
    private static final double RIGHT_ANGLE = 90;
    private static final double TURTLE_ANGLE_2 = (180 - TURTLE_ANGLE_1) / 2;

    /**
     * Calls Super class constructor. 
     * @param referenceDrawer
     */
    public FilledTurtleDrawer (TurtleDrawer referenceDrawer) {
        super(referenceDrawer);
    }

    /**
     * Implements a filled Triangle body
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
        vertex = translateCoordinates(vertex);
        leftPoint = translateCoordinates(leftPoint);
        rightPoint = translateCoordinates(rightPoint);
        pen.fillPolygon(new int[] { (int) vertex.x, (int) leftPoint.x, (int) rightPoint.x },
                        new int[] { (int) vertex.y, (int) leftPoint.y, (int) rightPoint.y }, 3);
    }

}
