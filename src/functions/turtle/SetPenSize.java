package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;

public class SetPenSize extends TurtleFunction {
        
    private static final int INPUT_VALUES = 1;
    
    public SetPenSize(Model model){
        super(model, INPUT_VALUES);
    }
    
    @Override
    public void process (Turtle turtle, double[] values) {
        int penSize = (int) values[0];
        turtle.setPenSize(penSize);
    }
}
