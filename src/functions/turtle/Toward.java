package functions.turtle;

import java.util.Queue;

import functions.TurtleFunction;
import backEnd.Model;
import backEnd.Turtle;

public class Toward extends TurtleFunction {
   
    public Toward(Turtle turtle, Model model){
        super(turtle, model);
    }

    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public double execute(Queue<String> commandQueue) throws Exception {
		double arg1 = getModel().performOperation(commandQueue);
		double arg2 = getModel().performOperation(commandQueue);
		double turn = getTurtle().setTowards(arg1, arg2);
		System.out.println(" TOWARD: toward(" + arg1 + ", " + arg2 + ") = " + Math.abs(turn));
		return Math.abs(turn);
	}
}
