package functions.bool;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

public class Equal extends Function {

    public Equal (Model model) {
        super(model);
    }
    @Override
    public double execute(Instruction toExecute) {
        if(getReturnValue(toExecute) == getReturnValue(toExecute)) {
            return 1;
        }
        return 0;
    }
}
