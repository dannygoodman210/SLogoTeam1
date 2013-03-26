package functions;

import backEnd.Instruction;
import backEnd.Model;

public class Add extends Function {

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
