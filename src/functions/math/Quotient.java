package functions.math;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

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
