package functions;

import backEnd.Turtle;

public class PenUp extends TurtleFunction{
	
	private static final int PCUT = 1;
	
	public PenUp(Turtle turtle){
		super(turtle, PCUT);
	}
	
	@Override
	public String execute(String[] input) {
		getTurtle().setPenDown(false);
		return "0";
	}


}