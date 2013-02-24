package functions;

import backEnd.Turtle;

public class Forward extends Function{
    private Turtle myTurtle;
    private double myDistance;
    
    public Forward (Turtle turtle, double distance) {
        myTurtle = turtle;
        myDistance = distance;
    }
    
    @Override
    public double execute () {
        myTurtle.move(myDistance);
        return 0;
    }

}
