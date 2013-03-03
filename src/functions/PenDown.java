package functions;

import backEnd.Turtle;

public class PenDown extends TurtleFunction {
	private static final int PCUT = 1;
	
	
	public PenDown(Turtle turtle){
		super(turtle, PCUT);
	}
	
	@Override
	public String execute(String[] input) {
		getTurtle().setPenDown(true);
		return "1";

	}

}
