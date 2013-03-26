package functions.block;


import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

/**
 * 
 * @author Francesco Agosti, Eunsu Ryu, Challen Herzberg-Brovold
 *
 */
public class If extends Function {
    
    /**
     * Simple if statement
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
            return getReturnValue(blockToExecute);
        }
        else {
            return 0;
        }
    }

}
