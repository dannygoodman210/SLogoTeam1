package functions.turtle;

import backEnd.Turtle;
import backEnd.Model;


public class PenUp extends TurtleFunction{

    private static final int INPUT_VALUES = 0;

    public PenUp(Model model){
        super(model, INPUT_VALUES);
    }

    @Override
    public void process(Turtle turtle, double[] values){
        turtle.setPenDown(false);
    }
}
