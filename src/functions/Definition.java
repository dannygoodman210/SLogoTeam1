package functions;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

public class Definition extends Function {
    
    public Definition (Model model) {
        super(model);
    }
    
    @Override
    public double execute(Instruction toExecute) {
        String name = toExecute.get(0);
        toExecute.progress();
        Instruction params = toExecute.block();
        Instruction commands = toExecute.block();
        if (!getModel().getMap().isNumber(name)) {
            return 0;
            // Throw warning that function is already defined
        }
        getModel().getMap().add(name, new UserDefined(getModel(), params, commands));
        return 1;       
    }
}
