package functions;

import backEnd.Turtle;

public class Ycor extends TurtleQuery {
	
	public Ycor(Turtle turtle) {
		super(turtle);
	}

	
	@Override
	public String execute(String[] input) {
		return getTurtle().getLocation().y + "";
	}

}
