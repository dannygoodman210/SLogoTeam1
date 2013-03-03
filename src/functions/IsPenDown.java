package functions;

import backEnd.Turtle;

public class IsPenDown extends TurtleQuery {
	
	public IsPenDown(Turtle turtle) {
		super(turtle);
	}

	
	@Override
	public String execute(String[] input) {
		return getTurtle().isPenDown() + "";
	}

}
