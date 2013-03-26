package functions;

import backEnd.Instruction;
import backEnd.Model;
    
/**
 * Function that defines user-generated functions
 * @author Francesco Agosti, Eunsu (Joe) Ryu, Challen Herzberg-Brovold
 *
 *
 */
public class Definition extends Function {
    
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
            return 0;
            // Throw warning that function is already defined
        }
        getModel().getMap().put(name, new UserDefined(getModel(), params, commands));
        return 1;       
    }
}
