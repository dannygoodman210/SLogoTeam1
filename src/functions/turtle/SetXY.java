package functions.turtle;

import java.util.Queue;

import functions.TurtleFunction;
import backEnd.Model;
import backEnd.Turtle;

public class SetXY extends TurtleFunction {
    
    public SetXY(Turtle turtle, Model model) {
        super(turtle, model);
    }

    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
    	double arg1 = getModel().performOperation(commandQueue, executing);
		double arg2 = getModel().performOperation(commandQueue, executing);
		if (executing) {
			System.out.println(" SetXY: (" + arg1 + "," + arg2 + "), distance = " + Math.sqrt(Math.pow(arg1, 2) + Math.pow(arg2,2))); //Delete in the final implementation
	        getTurtle().setLocation(arg1, arg2);
	        return Double.valueOf(Math.sqrt(Math.pow(arg1, 2) + Math.pow(arg2,2)));
		} return null;
		
    }

}
