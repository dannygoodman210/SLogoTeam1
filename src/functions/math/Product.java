package functions.math;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

public class Product extends Function {

    public Product (Model model) {
        super(model);
    }
    
    @Override
    public double execute (Instruction toExecute) {
        return getReturnValue(toExecute) * getReturnValue(toExecute);
    }
}
