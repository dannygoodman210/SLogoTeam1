package frontEnd;

import java.awt.Color;
import java.awt.Graphics2D;
import util.Location;
import util.Shape;


/**
 * Decorator that highlights the Turtle by drawing a rectangle around it.
 * 
 * @author Danny Goodman
 * 
 */
public class HighlightActiveTurtleDrawer extends DecoratedTurtleDrawer {

    private static final Color HIGHLIGHT_COLOR = Color.RED;

    /**
     * Creates a Highlight TurtleDrawer from the reference given
     * 
     * @param referenceDrawer
     */
    public HighlightActiveTurtleDrawer (TurtleDrawer referenceDrawer) {
        super(referenceDrawer);
    }

    /**
     * creates empty Decorator TurtleDrawer (see superclass)
     */
    public HighlightActiveTurtleDrawer () {
        super();
    }

    @Override
    public void drawBody (Graphics2D pen, double heading, int shapeIndex) {
        Location center = getTrail().get(getTrail().size() - 1).getEnd();
        center = translateCoordinates(center);
        pen.setColor(HIGHLIGHT_COLOR);
        Shape body = getShape(shapeIndex);
        pen.drawRect((int) center.x - body.getWidth() / 2, (int) center.y - body.getHeight() / 2,
                     body.getWidth(), body.getHeight());
        super.drawBody(pen, heading, shapeIndex);
    }

}
