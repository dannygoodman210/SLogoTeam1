package functions.turtle;

import backEnd.Turtle;
import backEnd.Model;


/**
 * Moves the turtle backward by specified amount
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Back extends TurtleFunction {
    
    private static final int INPUT_VALUES = 1;
    
    public Back (Model model) {
        super(model, INPUT_VALUES);
    }
    
    @Override
    public void process (Turtle turtle, double[] values) {
        turtle.move(-values[0]);
    }
}
