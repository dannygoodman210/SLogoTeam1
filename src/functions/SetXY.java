package functions;

import backEnd.Turtle;

public class SetXY extends TurtleFunction {

	private static final int SCUT = 3;
	
	public SetXY(Turtle turtle){
		super(turtle,SCUT);
	}
	
	@Override
	public String execute(String[] input) {
		int x = Integer.parseInt(input[1]);
		int y = Integer.parseInt(input[2]);
		getTurtle().setLocation(x, y);
		return "";
	}

}
