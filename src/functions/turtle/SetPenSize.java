package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;


/**
 * Sets the pen size in pixels
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class SetPenSize extends TurtleFunction {
        
    private static final int INPUT_VALUES = 1;
    
    public SetPenSize(Model model){
        super(model, INPUT_VALUES);
    }
    
    @Override
    public void process (Turtle turtle, double[] values) {
    	int pensize = (int) values[0];
        turtle.setPenSize(pensize);
    }
}
