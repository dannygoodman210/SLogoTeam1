package functions.turtle;

import backEnd.Turtle;
import backEnd.Model;

/**
 * Puts the pen down
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
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
