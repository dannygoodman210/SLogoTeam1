package functions.bool;

import java.util.Queue;

import functions.MathFunction;
import backEnd.Model;

public class NotOperation extends MathFunction {
    
    
    public NotOperation(Model model) {
        super(model);

    }

    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public double execute(Queue<String> commandQueue) throws Exception {
		double arg = getModel().performOperation(commandQueue);
		double output = arg>0? 1.0 : 0.0;
		System.out.println(" NOT(" + arg + ") = " + output);
		return output;
		
	}
}
