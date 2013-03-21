package functions.math;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

public class Minus extends Function {
    
    public Minus (Model model) {
        super(model);
    }
    
    public double execute (Instruction toExecute) {
        return -getReturnValue(toExecute);
    }

}
