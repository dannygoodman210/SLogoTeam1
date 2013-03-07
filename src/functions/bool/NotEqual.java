package functions.bool;

import java.util.Queue;

import functions.MathFunction;
import backEnd.Model;

public class NotEqual extends MathFunction {

    public NotEqual (Model model) {
        super(model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public double execute(Queue<String> commandQueue) throws Exception {
		double arg = (getModel().performOperation(commandQueue) != getModel().performOperation(commandQueue))? 1.0 : 0.0;
		System.out.println(" NOTEQUAL? " + arg);
		return arg;
	}
}