package functions.bool;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

public class Less extends Function {

    public Less (Model model) {
        super(model);
    }

    public double execute (Instruction toExecute) {
        if(getReturnValue(toExecute) < getReturnValue(toExecute)) {
            return 1;
        }
        return 0;
    }
}
