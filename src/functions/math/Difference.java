package functions.math;

import java.util.Queue;

import functions.MathFunction;
import backEnd.Model;
public class Difference extends MathFunction {

    public Difference (Model model) {
        super(model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     * USE COMMENTED CODE FOR FINAL IMPLEMENTATION
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
//		return executing? Double.valueOf(getModel().performOperation(commandQueue, executing)-getModel().performOperation(commandQueue, executing)) : null;
    	
		double arg1 = getModel().performOperation(commandQueue, executing);
		double arg2 = getModel().performOperation(commandQueue, executing);
		if (executing) {
			System.out.println(" DIFF: " + arg1 + " - " + arg2 + " = " + (arg1-arg2));
			return Double.valueOf(arg1-arg2);
		} else return null;
		
	}
}
