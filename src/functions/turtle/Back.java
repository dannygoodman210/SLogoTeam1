package functions.turtle;

import functions.TurtleFunction;
import backEnd.Model;
import backEnd.Turtle;
public class Back extends TurtleFunction {
    
    public Back (Turtle turtle, Model model) {
        super(turtle, model);
    }
    
    @Override
    public double execute (String[] input) {
    	double distance = getValue(input);
        getTurtle().move(-distance);
        return distance;
    }
    

}
