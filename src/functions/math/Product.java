package functions.math;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;


/**
 * Multiplies the inputs
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Product extends Function {

    public Product (Model model) {
        super(model);
    }
    
    @Override
    public double execute (Instruction toExecute) {
        return getReturnValue(toExecute) * getReturnValue(toExecute);
    }
}
