package functions.bool;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;
/**
 * Performs OR test1 test2, and	returns 1 if test1 or test2 are non-zero, otherwise 0
 * @author Eunsu (Joe) Ryu
 *
 */
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
