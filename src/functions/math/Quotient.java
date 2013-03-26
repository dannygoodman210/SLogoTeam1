package functions.math;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;


/**
 * Dividies the former input by the latter input
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Quotient extends Function {

    public Quotient (Model model) {
        super(model);
    }
    @Override
    public double execute(Instruction toExecute) {
        return (int) getReturnValue(toExecute) /
                getReturnValue(toExecute);
        
    }

}
