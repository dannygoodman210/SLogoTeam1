package functions.turtle;

import java.util.Queue;

import backEnd.Model;
import backEnd.Turtle;

public class IsPenDown extends TurtleQuery {

    public IsPenDown(Turtle turtle, Model model) {
        super(turtle, model);
    }

    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
//    	return executing? ( Double.valueOf((getTurtle().isPenDown())? 1.0 : 0.0) ) : null;
    	
    	if (executing) {
    		System.out.println("IsPenDown = " + (getTurtle().isPenDown()));
        	return Double.valueOf( (getTurtle().isPenDown())? 1.0 : 0.0 );
    	} return null;
    	
    }
}
