package functions;

import backEnd.Instruction;
import backEnd.Model;
    
/**
 * Function that defines user-generated function, creates one, and adds this
 * function to our map. 
 * @author Francesco Agosti, Eunsu (Joe) Ryu, Challen Herzberg-Brovold
 *
 *
 */
public class Definition extends Function {
    
	
	private static final String DOUBLEFUNCTION = "Be careful, you just overwrote an old function";
    /**
     * 
     * @param model 
     */
    public Definition (Model model) {
        super(model);
    }
    
    @Override
    public double execute(Instruction toExecute) {
        String name = toExecute.get(0);
        toExecute.progress();
        Instruction params = toExecute.block();
        Instruction commands = toExecute.block();
        if (getModel().getMap().contains(name)) {
        	getModel().showErrorMsg(DOUBLEFUNCTION);
            return 0;
            
        }
        getModel().getMap().put(name, new UserDefined(getModel(), params, commands));
        return 1;       
    }
}
