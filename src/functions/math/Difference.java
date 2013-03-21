package functions.math;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;
public class Difference extends Function {

    public Difference (Model model) {
        super(model);
    }
    
    public double execute (Instruction toExecute) {
        return getReturnValue(toExecute) - getReturnValue(toExecute);
    }
}
