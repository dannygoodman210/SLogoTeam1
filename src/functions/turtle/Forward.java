package functions.turtle;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;


public class Forward extends Function{
    
    public Forward (Model model) {
        super(model);
    }
    
    @Override
    public double execute (Instruction toExecute) {
    	double distance = getReturnValue(toExecute);
        getTurtle().move(distance);
        return distance;
    }

}
