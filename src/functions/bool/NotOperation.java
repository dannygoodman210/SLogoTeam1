package functions.bool;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;


/**
 * Performs NOt test, and returns 1 if test is 0 and 0 if test is non-zero
 * @author Eunsu (Joe) Ryu
 *
 */
public class NotOperation extends Function {
    
    
    public NotOperation(Model model) {
        super(model);

    }

    public double execute (Instruction toExecute) {
        if(getReturnValue(toExecute) == 0) {
            return 1;
        }
        return 0;
    }
}
