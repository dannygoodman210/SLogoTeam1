package functions;

import backEnd.Turtle;

public class SetHeading extends TurtleFunction {

	public SetHeading(Turtle turtle){
		super(turtle);
	}
	
	@Override
	public void execute(String[] input) {
		int angle = Integer.parseInt(input[1]);
		getTurtle().setHeading(angle);

	}

}
