package functions.turtle;

import functions.Function;
import backEnd.Executable;
import backEnd.Model;
import backEnd.Turtle;
import backEnd.Instruction;

public class Towards extends Function {
    
    
    public Towards(Model model){
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
    	double value1 = getReturnValue(toExecute);
    	double value2 = getReturnValue(toExecute);
        double turn = getTurtle().setTowards(value1, value2);
        return Math.abs(turn);
    }

}
