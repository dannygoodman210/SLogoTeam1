package functions.math;

import java.util.Queue;

import functions.MathFunction;
import backEnd.Model;

public class Remainder extends MathFunction {

    public Remainder (Model model) {
        super(model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public double execute(Queue<String> commandQueue) throws Exception {
		double arg1 = getModel().performOperation(commandQueue);
		double arg2 = getModel().performOperation(commandQueue);
		System.out.println(" REMAINDER: " + arg1 + " % " + arg2 + " = " + (arg1%arg2));
		return arg1%arg2;
	}

}
