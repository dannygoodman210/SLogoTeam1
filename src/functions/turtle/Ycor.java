package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;


/**
 * Returns the Y coordinate of turtle
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Ycor extends Function {
    
    public Ycor(Model model) {
        super(model);
    }

    @Override
    public double execute (Instruction toExecute) {
        return getModel().getLastTurtle().getLocation().y;
    }
}