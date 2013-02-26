package functions;

import backEnd.Turtle;

public class Forward extends TurtleFunction{
    private double myDistance;
    
    public Forward (Turtle turtle, double distance) {
        super(turtle);
        myDistance = distance;
    }
    
    @Override
    public double execute () {
        getTurtle().move(myDistance);
        return myDistance;
    }

}
