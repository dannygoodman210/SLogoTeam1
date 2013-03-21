package functions.bool;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

public class OrOperation extends Function {

    public OrOperation (Model model) {
        super(model);

    }

    public double execute (Instruction toExecute) {
        if(getReturnValue(toExecute) != 0 || getReturnValue(toExecute) != 0) {
            return 1;
        }
        return 0;
    }
}
