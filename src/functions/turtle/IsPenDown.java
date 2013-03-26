package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;


/**
 * Return 1 if the pen is down
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class IsPenDown extends Function {

    public IsPenDown(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
    	return getModel().getLastTurtle().isPenDown()? 1: 0;
    }
}
