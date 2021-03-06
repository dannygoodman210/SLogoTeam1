package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;


/**
 * Returns the color of the pen
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class GetPenColor extends Function {

    public GetPenColor(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
    	return getModel().getLastTurtle().getPenColorIndex();
    }
}
