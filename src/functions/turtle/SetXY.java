package functions.turtle;

import functions.TurtleFunction;
import backEnd.Model;
import backEnd.Turtle;

public class SetXY extends TurtleFunction {

    private static final int DEFAULT_ARGS = 2;
    
    public SetXY(Turtle turtle, Model model) {
        super(turtle, model, DEFAULT_ARGS);
    }

    @Override
    public double execute(String[] input) {
        double[] values = getValue(input, 2);
        getTurtle().setLocation(values[0], values[1]);
        return values[0] + values[1];
    }

}
