package functions;

import backEnd.Turtle;

public class Left extends TurtleFunction {
    private double myAngle;
    
    public Left (Turtle turtle, double angle) {
        super(turtle);
        myAngle = angle;
    }
    @Override
    public double execute () {
        getTurtle().setHeading(myAngle);
        return myAngle;
    }

}
