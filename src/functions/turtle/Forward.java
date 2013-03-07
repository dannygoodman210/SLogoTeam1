package functions.turtle;


import java.util.Queue;

import functions.TurtleFunction;
import backEnd.Model;
import backEnd.Turtle;

public class Forward extends TurtleFunction{
    
    public Forward (Turtle turtle, Model model) {
        super(turtle, model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
	public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
    	double arg = getModel().performOperation(commandQueue, executing);
    	if (executing) {
    		System.out.println(" FORWARD: fd(" + arg + ") = " + arg); //Delete in the final implementation
    		getTurtle().move(arg);
    		return Double.valueOf(arg);
    	} return null;
    }


}
