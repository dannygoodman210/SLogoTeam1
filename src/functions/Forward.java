package functions;

import backEnd.Model;
import backEnd.Turtle;

public class Forward extends TurtleFunction{
    
    public Forward (Turtle turtle, Model model) {
        super(turtle, model);
    }
    
    @Override
    public double execute (String[] input) {
    	double distance = getValue(input);
        getTurtle().move(distance);
        return distance;
    }

}
