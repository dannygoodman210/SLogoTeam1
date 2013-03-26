package functions.block;

import backEnd.Instruction;
import backEnd.Model;
import functions.Constant;
import functions.Function;

/**
 * Repeat function: repeats a group of commands for a specified number of times
 * @author Francesco Agosti, Eunsu (Joe) Ryu, Challen Herzberg-Brovold
 *
 */
public class Repeat extends Function {

    private final String myRepCount = ":repcount";
    
    /**
     * 
     * @param model 
     */
    public Repeat (Model model) {
        super(model);
    }

    @Override
    public double execute (Instruction toExecute) {
        double reps = getReturnValue(toExecute);
        Instruction blockToExecute = toExecute.block();
        for (int i = 0; i < reps; i++) {
            getModel().getMap().put(myRepCount, new Constant(i + 1));
            executeBlock(blockToExecute);
        }
        return reps;
    }
}
