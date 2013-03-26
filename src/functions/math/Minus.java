package functions.math;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

/**
 * Negates the input
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Minus extends Function {
    
    public Minus (Model model) {
        super(model);
    }
    
    public double execute (Instruction toExecute) {
        return -getReturnValue(toExecute);
    }

}
