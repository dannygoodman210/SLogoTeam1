package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;

/**
 * Roates the turtle toward the specified point on the screen
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Towards extends TurtleFunction {
    
    private static final int INPUT_VALUES = 2;
    private double returnValue;
    
    public Towards(Model model){
        super(model, INPUT_VALUES);
    }
    
    @Override
    public double getReturn (double[] values) {
        return returnValue;
    }
    
    @Override
    public void process (Turtle turtle, double[] values) {
        returnValue = turtle.setTowards(values[0], values[1]);
    }
}
