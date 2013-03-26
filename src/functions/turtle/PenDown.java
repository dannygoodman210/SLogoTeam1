package functions.turtle;

import backEnd.Turtle;
import backEnd.Model;

public class PenDown extends TurtleFunction {
    
    private static final int INPUT_VALUES = 0;

    public PenDown(Model model){
        super(model, INPUT_VALUES);
    }

    @Override
    public void process(Turtle turtle, double[] values){
        turtle.setPenDown(true);
    }

}
