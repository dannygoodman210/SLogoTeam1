package functions.turtle;

import java.util.Queue;

import backEnd.Model;
import backEnd.Turtle;

public class MakeInvisible extends TurtleQuery {
	/**
     * Hides turtle
     * @author Eunsu Ryu
     */

    public MakeInvisible(Turtle turtle, Model model) {
        super(turtle, model);
    }

    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     * USE COMMENTED CODE FOR FINAL IMPLEMENTATION
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {    	
    	if (executing) {
    		System.out.println(" HIDE TURTLE"); //Delete in the final implementation
    		getTurtle().setVisible(false);
        	return Double.valueOf(0.0);
    	} return null;
    	
    }
}
