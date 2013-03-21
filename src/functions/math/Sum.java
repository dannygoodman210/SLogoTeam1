package functions.math;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

public class Sum extends Function {

    public Sum (Model model) {
        super(model);
    }
    
    @Override
    public double execute (Instruction toExecute) {
        return getReturnValue(toExecute) + getReturnValue(toExecute);
    }

}
