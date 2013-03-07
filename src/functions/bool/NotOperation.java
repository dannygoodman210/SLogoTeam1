package functions.bool;

import java.util.Queue;

import functions.MathFunction;
import backEnd.Model;

public class NotOperation extends MathFunction {
	/**
     * Performs boolean negation
     * @author Eunsu Ryu
     */
    
    public NotOperation(Model model) {
        super(model);

    }

    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     * USE COMMENTED CODE FOR FINAL IMPLEMENTATION
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
//		Double output = (getModel().performOperation(commandQueue, executing)>0)? 1.0 : 0.0;
//		return executing? Double.valueOf(output) : null;
		
    	
		Double arg = getModel().performOperation(commandQueue, executing);
		Double output = arg>0? 1.0 : 0.0;
		if (executing) {
			System.out.println(" NOT(" + arg + ") = " + output);
			return Double.valueOf(output);
		} else return null;
		
		
	}
}
