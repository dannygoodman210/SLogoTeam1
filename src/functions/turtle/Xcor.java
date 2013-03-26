package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;


/**
 * Returns the X coordinate of turtle
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Xcor extends Function {
    
    public Xcor(Model model) {
        super(model);
    }

    @Override
    public double execute (Instruction toExecute) {
        return getModel().getLastTurtle().getLocation().x;
    }
}
