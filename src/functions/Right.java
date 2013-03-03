package functions;

import backEnd.Turtle;

public class Right extends TurtleFunction {

	
	public Right (Turtle turtle){
		super(turtle);
	}
	
	@Override
	public void execute(String[] args) {
		int angle = Integer.parseInt(args[1]);
		getTurtle().rotate(-angle);
	}

}
