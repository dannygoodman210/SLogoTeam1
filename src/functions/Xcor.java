package functions;

import backEnd.Turtle;

public class Xcor extends TurtleQuery {
	
	public Xcor(Turtle turtle) {
		super(turtle);
	}

	
	@Override
	public String execute(String[] input) {
		return getTurtle().getLocation().x + "";
	}

}
