package functions;

import backEnd.Turtle;

public class IsVisible extends TurtleQuery {
	
	public IsVisible(Turtle turtle) {
		super(turtle);
	}

	
	@Override
	public String execute(String[] input) {
		return getTurtle().isVisible() + "";
	}

}
