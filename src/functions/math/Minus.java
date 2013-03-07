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
    public double execute(Queue<String> commandQueue) throws Exception {
    	double arg = getModel().performOperation(commandQueue);
		System.out.println(" MINUS: -1*" + arg + " = " + -arg);
		return -arg;
	}

}
