package functions;

import backEnd.Turtle;

public class Heading extends TurtleQuery {
	
	public Heading(Turtle turtle) {
		super(turtle);
	}

	
	@Override
	public String execute(String[] input) {
		return getTurtle().getHeading() + "";
	}

}
