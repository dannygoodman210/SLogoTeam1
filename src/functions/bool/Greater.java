package functions.bool;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

public class Greater extends Function {

    public Greater (Model model) {
        super(model);
    }

    @Override
    public double execute (Instruction toExecute) {
        if(getReturnValue(toExecute) > getReturnValue(toExecute)) {
            return 1;
        }
        return 0;
    }
}
