package functions.block;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

/**
 * If statement with the else part
 * @author Eunsu (Joe) Ryu, Francesco Agosti, Challen Herzberg-Brovold
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
            return executeBlock(trueCommand);
        }
        else {
            return executeBlock(falseCommand);
        }
    }
}
