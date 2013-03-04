package frontEnd;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import util.Location;
import util.Vector;


public class DefaultTurtleDrawer extends TurtleDrawer {

    private static final int TURTLE_HEIGHT = 30;
    private static final double TURTLE_ANGLE_1 = 40;
    private static final double TRIANGLE_DEGREES = 180;
    private static final double RIGHT_ANGLE = 90;
    private static final double TURTLE_ANGLE_2 = (180 - TURTLE_ANGLE_1) / 2;
    protected List<Location> myTrailPoints;

    public DefaultTurtleDrawer (TurtleView view) {
        myTrailPoints = new ArrayList<Location>();
        setView(view);
    }

    @Override
    public Location drawBody (Graphics pen, Location start, Location finish, double heading) {
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
        return finish;
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
        pen.setColor(Color.BLACK);
        for (int i = 0; i < myTrailPoints.size() - 1; i += 2) {
            drawLine(pen, myTrailPoints.get(i), myTrailPoints.get(i + 1));
        }
    }

    protected void drawLine (Graphics pen, Location start, Location finish) {
        start = getView().translateCoordinates(start);
        finish = getView().translateCoordinates(finish);
        pen.drawLine((int) start.getX(), (int) start.getY(),
                     (int) finish.getX(), (int) finish.getY());
    }

}
