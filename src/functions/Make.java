package functions;

import backEnd.Instruction;
import backEnd.Model;

/**
 * This function assigns numeric value to a variable
 * @author Eunsu (Joe) Ryu, Francesco Agosti, Challen Herzberg-Brovold
 *
 */
public class Make extends Function {
    
    /**
     * 
     * @param model 
     */ 
    public Make(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        String variable = toExecute.get(0);
        toExecute.progress();
        double value = getReturnValue(toExecute);
        Constant toAdd = new Constant((int)value);
        getModel().getMap().put(variable, toAdd);
        getModel().getController().sendVariable(variable, (int)value);
        return value;
    }
}
