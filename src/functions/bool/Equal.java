package functions.bool;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;


/**
 * Performs EQUAL? value1 value2, and returns 1 if value1 and value2 are equal, otherwise 0
 * @author Eunsu (Joe) Ryu
 *
 */
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
