package functions;

import backEnd.Instruction;
import backEnd.Model;

/**
 * Activate odd
 * @author Francesco Agosti, Eunsu Ryu, Challen Herzberg-Brovold
 *
 */
public class TellOdd extends Function {

    /**
     * 
     * @param model 
     */
    public TellOdd(Model model) {
        super(model);
    }
    
    /**
     * makes all odd turtles active
     * @param toExecute 
     */
    public double execute(Instruction toExecute) {
        return getTurtleList().activateEvenOdd(1);

    }

}
