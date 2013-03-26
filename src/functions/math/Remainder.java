package functions.math;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

/**
 * Computes the remainder of division: input1%input2
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Remainder extends Function {

    public Remainder (Model model) {
        super(model);
    }
    @Override
    public double execute (Instruction toExecute) {
        int numerator = (int) getReturnValue(toExecute);
        int denominator = (int)getReturnValue(toExecute);
        return numerator%denominator;
        
    }

}
