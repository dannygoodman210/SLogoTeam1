package functions.turtle;

import backEnd.Turtle;
import backEnd.Model;


/**
 * Moves the turtle forward by specified amount
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Forward extends TurtleFunction{
    
    private static final int INPUT_VALUES = 1;
    
    public Forward (Model model) {
        super(model, INPUT_VALUES);
    }
    
    @Override
    public void process (Turtle turtle, double[] values) {
        turtle.move(values[0]);
    }
}
