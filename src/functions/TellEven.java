package functions;

import backEnd.Instruction;
import backEnd.Model;

/**
 * Activate even
 * @author Francesco Agosti, Eunsu Ryu, Challen Herzberg-Brovold
 *
 */
public class TellEven extends Function {
    
    /**
     * 
     * @param model 
     */
    public TellEven(Model model) {
        super(model);
    }
    
    /**
     * @param toExecute 
     */
    public double execute(Instruction toExecute) {
        return getTurtleList().activateEvenOdd(0);

    }
}
