package functions.bool;

import java.util.Queue;

import functions.MathFunction;
import backEnd.Model;

public class AndOperation extends MathFunction {

    public AndOperation(Model model) {
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
		double output = (arg1>0)&&(arg2>0) ? 1.0 : 0.0;
		System.out.println(" AND(" + arg1 + ", " + arg2 + ") = " + output);
		return output;
		
	}

}
