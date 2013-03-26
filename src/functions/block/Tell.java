package functions.block;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

/**
 * 
 * @author Francesco Agosti, Eunsu Ryu, Challen Herzberg-Brovold
 *
 */
public class Tell extends Function {


    /**
     * 
     * @param model 
     */
    public Tell(Model model) {
        super(model);
    }
    
    /**
     * executes Tell
     * @param toExecute 
     * 
     */
    public double execute(Instruction toExecute) {
        Instruction turtlesToTell = toExecute.block();
        getTurtleList().disactivateAll();
        double toReturn = 0;
        while (turtlesToTell.length() > 0) {
            toReturn = getReturnValue(turtlesToTell);
            getTurtleList().activate((int)toReturn);
        }
        return toReturn;
    }
}