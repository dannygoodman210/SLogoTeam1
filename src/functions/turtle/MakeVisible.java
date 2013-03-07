package functions.turtle;

import java.util.Queue;

import backEnd.Model;
import backEnd.Turtle;

public class MakeVisible extends TurtleQuery {
	/**
     * Shows turtle
     * @author Eunsu Ryu
     */

    public MakeVisible(Turtle turtle, Model model) {
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
    		System.out.println(" SHOW TURTLE"); //Delete in the final implementation
    		getTurtle().setVisible(true);
        	return Double.valueOf(1.0);
    	} return null;
    	
    }
}
