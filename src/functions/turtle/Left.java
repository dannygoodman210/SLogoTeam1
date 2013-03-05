package functions.turtle;

import functions.TurtleFunction;
import backEnd.Model;
import backEnd.Turtle;

public class Left extends TurtleFunction {
    
    public Left (Turtle turtle, Model model) {
        super(turtle, model);
    }

    @Override
    public double execute (String[] input) {
        double angle = getValue(input);
        getTurtle().rotate(angle);
        return angle;
    }
}
