package functions;

import backEnd.Instruction;
import backEnd.Model;

/**
 * Add new turtle at a specified position
 * @author Francesco Agosti, Eunsu (Joe) Ryu, Challen Herzberg-Brovold
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
