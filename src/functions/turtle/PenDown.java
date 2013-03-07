package functions.turtle;

import java.util.Queue;

import functions.TurtleFunction;
import backEnd.Model;
import backEnd.Turtle;

public class PenDown extends TurtleFunction {
    

    public PenDown(Turtle turtle, Model model){
        super(turtle, model);
    }
    
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
    	if (executing) { 
    		System.out.println(" PENDOWN"); //Delete in the final implementation
    		getTurtle().setPenDown(true);
    		return Double.valueOf(1.0);
    	} return null;
    	
    }

}
