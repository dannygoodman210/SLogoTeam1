package functions.block;

import backEnd.Instruction;
import backEnd.Model;
import backEnd.TurtleList;
import functions.Function;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Francesco Agosti, Eunsu Ryu, Challen Herzberg-Brovold
 *
 */
public class Ask extends Function {
    
    /**
     * asks for certain turtles to be moved
     * @param model 
     */
    public Ask (Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        Instruction turtlesToAsk = toExecute.block();
        TurtleList turtles = getTurtleList();
        Set<Integer> oldIDSet = new HashSet<Integer>(turtles.getActiveIDs());
        turtles.disactivateAll();
        while (turtlesToAsk.clone().length() > 0) {
            getTurtleList().activate((int)getReturnValue(turtlesToAsk));
        }
        double toReturn = getReturnValue(toExecute.block());
        turtles.setActive(oldIDSet);
        return toReturn;
    }
}
