package functions.turtle;

import java.util.Queue;

import functions.TurtleFunction;
import backEnd.Model;
import backEnd.Turtle;
public class Back extends TurtleFunction {
    
    public Back (Turtle turtle, Model model) {
        super(turtle, model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public double execute(Queue<String> commandQueue) throws Exception {
    	double arg = getModel().performOperation(commandQueue);
    	getTurtle().move(-arg);
		System.out.println(" BACK: back(" + arg + ") = " + arg);
		return arg;
    }
    

}
