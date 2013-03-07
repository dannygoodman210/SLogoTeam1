package functions.turtle;

import java.util.Queue;

import backEnd.Model;
import backEnd.Turtle;

public class Xcor extends TurtleQuery {
	
	public Xcor(Turtle turtle, Model model) {
		super(turtle, model);
	}

	
	/**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     * USE COMMENTED CODE FOR FINAL IMPLEMENTATION
     */
	@Override
	public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
//		return executing? Double.valueOf(getTurtle().getLocation().x) : null;
		
		if (executing) {
			System.out.println("Xcor = " + getTurtle().getLocation().x);
			return Double.valueOf(getTurtle().getLocation().x);
		} return null;
		
	}

}
