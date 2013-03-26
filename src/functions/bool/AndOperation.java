package functions.bool;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

/**
 * Performs AND test1 test2, and returns 1 if test1 and test2 are non-zero, otherwise 0
 * @author Eunsu (Joe) Ryu
 *
 */
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
