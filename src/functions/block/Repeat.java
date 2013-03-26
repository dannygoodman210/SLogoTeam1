package functions.block;

import backEnd.Instruction;
import backEnd.Model;
import functions.Constant;
import functions.Function;

/**
 * 
 * @author Francesco Agosti, Eunsu Ryu, Challen Herzberg-Brovold
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
            getReturnValue(blockToExecute);
        }
        return reps;
    }
}
