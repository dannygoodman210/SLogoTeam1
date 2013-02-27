package functions;

import backEnd.Turtle;

public class Left extends TurtleFunction {
    private double myAngle;
    
    public Left (Turtle turtle, double angle) {
        super(turtle);
        myAngle = angle;
    }
    
    @Override
    public void execute (String input) {
        getTurtle().setHeading(myAngle);
    }
    
    @Override
    public String getOutput (String input) {
        return "";
    }
}
