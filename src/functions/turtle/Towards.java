package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import backEnd.Turtle;

public class Towards extends TurtleFunction {
    
    private static final int INPUT_VALUES = 2;
    
    public Towards(Model model){
        super(model, INPUT_VALUES);
    }

    @Override
    public double execute(Instruction toExecute) {
    	double value1 = getReturnValue(toExecute);
    	double value2 = getReturnValue(toExecute);
        double turn = getTurtle().setTowards(value1, value2);
        return Math.abs(turn);
    }
    
    @Override 
    public double execute (Instruction toExecute) {
        return getReturn(getValues(toExecute));
    }
    
    @Override
    public double getReturn (double[] values) {
        return Math.abs(getTurtle)
    }

}
