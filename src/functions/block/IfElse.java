package functions.block;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;


public class IfElse extends Function {

    public IfElse (Model model) {
        super(model);
    }

    public double execute (Instruction toExecute) {
        double condition = getReturnValue(toExecute);
        Instruction trueCommand = toExecute.block();
        Instruction falseCommand = toExecute.block();
        if (condition != 0) {
            return getReturnValue(trueCommand);
        }
        else {
            return getReturnValue(falseCommand);
        }
    }
}
