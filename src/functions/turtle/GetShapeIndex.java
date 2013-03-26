package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;


/**
 * Returns the shape of turtle
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class GetShapeIndex extends Function {

    public GetShapeIndex(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
    	return getModel().getLastTurtle().getShapeIndex();
    }
}
