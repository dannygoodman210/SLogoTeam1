package functions.bool;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

public class AndOperation extends Function {

    public AndOperation(Model model) {
        super(model);

    }

    @Override
    public double execute (Instruction toExecute) {
        if(getReturnValue(toExecute) != 0 && getReturnValue(toExecute) != 0) {
            return 1;
        }
        return 0;
    }
}
