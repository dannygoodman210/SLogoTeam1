package functions;

import backEnd.Turtle;

public class Towards extends TurtleFunction {
	private static final int TCUT = 3;
	
	public Towards(Turtle turtle){
		super(turtle, TCUT);
	}
	
	@Override
	public String execute(String[] input) {
		int x = Integer.parseInt(input[1]);
		int y = Integer.parseInt(input[2]);
		getTurtle().setTowards(x, y);
		return "";
	}

}
