package functions.turtle;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

public class Back extends Function {
    
    public Back (Model model) {
        super(model);
    }
    
    @Override
    public double execute (Instruction toExecute) {
    	double distance = getReturnValue(toExecute);
        getTurtle().move(-distance);
        return distance;
    }
    

}
