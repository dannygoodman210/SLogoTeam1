package functions.bool;

import java.util.Queue;

import functions.MathFunction;
import backEnd.Model;

public class AndOperation extends MathFunction {
	/**
     * Handles boolean and operation
     * @author Eunsu Ryu
     */

    public AndOperation(Model model) {
        super(model);

    }

    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     * USE COMMENTED CODE FOR FINAL IMPLEMENTATION
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
//		Double output = executing&&(getModel().performOperation(commandQueue, executing)>0)&&(getModel().performOperation(commandQueue, executing)>0) ? 1.0 : 0.0;
//		return executing? Double.valueOf(output) : null;
    	
		Double arg1 = getModel().performOperation(commandQueue, executing);
		Double arg2 = getModel().performOperation(commandQueue, executing);
		Double output = (arg1>0)&&(arg2>0) ? 1.0 : 0.0;
		if (executing) {
			System.out.println(" AND(" + arg1 + ", " + arg2 + ") = " + output);
			return Double.valueOf(output);
		} else return null;
		
		
	}

}
