package functions;

import backEnd.Turtle;

public class SetHeading extends TurtleFunction {

	public SetHeading(Turtle turtle){
		super(turtle);
	}
	
	@Override
	public String execute(String[] input) {
		int angle = Integer.parseInt(input[1]);
		getTurtle().setHeading(angle);
		return angle + "";
	}

}
