package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;

public class Left extends TurtleFunction {
    
    private static final int INPUT_VALUES = 1;
    
    public Left (Model model) {
        super(model, INPUT_VALUES);
    }
    
    @Override
    public void process (Turtle turtle, double[] values) {
        turtle.rotate(values[0]);
    }
}
