package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;

public class SetXY extends TurtleFunction {
    
    private static final int INPUT_VALUES = 2;
    
    public SetXY(Model model) {
        super(model, INPUT_VALUES);
    }

    @Override
    public void process (Turtle turtle, double[] values) {
        turtle.setLocation(values[1], values[0]);
    }
    
    @Override
    public double getReturn (double[] values) {
        return values[0] + values[1];
    }

}
