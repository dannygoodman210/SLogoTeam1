package functions.bool;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;


/**
 * Performs LESS? value1 value2, and returns 1 if value1 is strictly less than value2, otherwise 0
 * @author Eunsu (Joe) Ryu
 *
 */
public class Less extends Function {

    public Less (Model model) {
        super(model);
    }

    public double execute (Instruction toExecute) {
        if(getReturnValue(toExecute) < getReturnValue(toExecute)) {
            return 1;
        }
        return 0;
    }
}
