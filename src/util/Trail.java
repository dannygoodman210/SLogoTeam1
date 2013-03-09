package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import frontEnd.TurtleView;


public class Trail {

    protected Location myStart;
    protected Location myEnd;
    protected Color myColor;
    protected Rectangle myBounds;

    public Trail (Location start, Location end, Color penColor, Rectangle bounds) {
        myStart = start;
        myEnd = end;
        myColor = penColor;
        myBounds = bounds;
    }

    public void paint (Graphics pen) {
        pen.setColor(myColor);
        drawLine(pen, myStart, myEnd);
    }

    public Location getStart () {
        return myStart;
    }

    public Location getEnd () {
        return myEnd;
    }

    public void setColor (Color color) {
        myColor = color;
    }

    public Color getColor () {
        return myColor;
    }

    protected void drawLine (Graphics pen, Location start, Location finish) {
        start = translateCoordinates(start);
        finish = translateCoordinates(finish);
        pen.drawLine((int) start.getX(), (int) start.getY(),
                     (int) finish.getX(), (int) finish.getY());
    }

    protected Location translateCoordinates (Location point) {
        int centerX = (int) myBounds.getWidth() / 2;
        int centerY = (int) myBounds.getHeight() / 2;
        return new Location(centerX + point.getX(), centerY - point.getY());
    }

    public Trail warp () {
        return new WarpedTrail(myStart, myEnd, myColor, myBounds);
    }

    public int[] getWarps () {
        return new int[] { 0, 0, 0, 0 };
    }

    @Override
    public String toString () {
        return "{" + myStart + " | " + myEnd + "}";
    }

}
