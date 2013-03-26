package functions.bool;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;


/**
 * Performs NOTEQUAL? value1 value2 and returns 1 if value1 and value2 are not equal, otherwise 0
 * @author Eunsu (Joe) Ryu
 *
 */
public class NotEqual extends Function {

    public NotEqual (Model model) {
        super(model);
    }

    public double execute (Instruction toExecute) {
        if(getReturnValue(toExecute) !=  getReturnValue(toExecute)) {
            return 1;
        }
        return 0;
    }
}