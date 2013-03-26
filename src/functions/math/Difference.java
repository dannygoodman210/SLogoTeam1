package functions.math;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

/**
 * Computes the difference between two numbers
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Difference extends Function {

    public Difference (Model model) {
        super(model);
    }
    
    public double execute (Instruction toExecute) {
        return getReturnValue(toExecute) - getReturnValue(toExecute);
    }
}
