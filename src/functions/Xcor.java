package functions;

import backEnd.Model;
import backEnd.Turtle;

public class Xcor extends TurtleQuery {
	
	public Xcor(Turtle turtle, Model model) {
		super(turtle, model);
	}

	
	@Override
	public double execute(String[] input) {
		return getTurtle().getLocation().x;
	}

}
