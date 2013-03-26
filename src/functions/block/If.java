package functions.block;


import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

/**
 * If statement
 * @author Eunsu (Joe) Ryu, Francesco Agosti, Challen Herzberg-Brovold
 *
 */
public class If extends Function {
    
    /**
     * Simple if statement, without else part.
     * @param model  
     */
    public If(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        double value = getReturnValue(toExecute);
        Instruction blockToExecute = toExecute.block();
        if (value != 0) {
            return executeBlock(blockToExecute);
        }
        else {
            return 0;
        }
    }

}
