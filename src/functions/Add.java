package functions;

import backEnd.Instruction;
import backEnd.Model;

/**
 * 
 * @author Francesco Agosti, Eunsu Ryu, Challen Herzberg-Brovold
 *
 *
 */
public class Add extends Function {
    
    /**
     * 
     * @param model 
     */
    public Add (Model model) {
        super(model);
    }

    @Override
    public double execute (Instruction toExecute) {
        int x = (int) getReturnValue(toExecute);
        int y = (int) getReturnValue(toExecute);
        getModel().addNewTurtle(x, y);
        return 1;
    }

}
