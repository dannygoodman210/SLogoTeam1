package functions.math;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

/**
 * Computes the sum of two numbers
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Sum extends Function {

    public Sum (Model model) {
        super(model);
    }
    
    @Override
    public double execute (Instruction toExecute) {
        return getReturnValue(toExecute) + getReturnValue(toExecute);
    }

}
