package functions.block;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

/**
 * 
 * @author Francesco Agosti, Eunsu Ryu, Challen Herzberg-Brovold
 *
 */
public class IfElse extends Function {

    /**
     * Ifelse statement
     * @param model 
     */
    public IfElse (Model model) {
        super(model);
    }
    
    /**
     * executes the statement
     * @param toExecute 
     * @return 
     */
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
