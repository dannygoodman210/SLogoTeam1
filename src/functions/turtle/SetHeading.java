package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;


/**
 * Sets the heading angle of the turtle
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class SetHeading extends TurtleFunction {
        
    private static final int INPUT_VALUES = 1;
    
    public SetHeading(Model model){
        super(model, INPUT_VALUES);
    }
    
    @Override
    public void process (Turtle turtle, double[] values) {
        turtle.setHeading(values[0]);
    }
}
