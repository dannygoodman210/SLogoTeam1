package functions.turtle;

import functions.TurtleFunction;
import backEnd.Model;
import backEnd.Turtle;

public class PenUp extends TurtleFunction{
	
	private static final int DEFAULT_ARGS = 0;
	
	public PenUp(Turtle turtle, Model model){
		super(turtle, model, DEFAULT_ARGS);
	}
	
	@Override
	public double execute(String[] input) {
		getTurtle().setPenDown(false);
		return 0;
	}


}
