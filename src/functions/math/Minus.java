package functions.math;

import java.util.Queue;

import functions.MathFunction;
import backEnd.Model;

public class Minus extends MathFunction {
    
    
    public Minus (Model model) {
        super(model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
//    	Double output = Double.valueOf(-getModel().performOperation(commandQueue, executing)); 
//    	return executing? output : null;
    	
    	
    	Double arg = getModel().performOperation(commandQueue, executing);
    	if (executing) {
    		System.out.println(" MINUS: -1*" + arg + " = " + -arg);
    		return Double.valueOf(-arg);
    	} else return null;
		
	}

}
