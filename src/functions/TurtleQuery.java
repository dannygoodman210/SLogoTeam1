package functions;

import backEnd.Model;
import backEnd.Turtle;

public abstract class TurtleQuery extends TurtleFunction {
	private static final int DEFAULT_ARGS = 0;
	
	public TurtleQuery(Turtle turtle, Model model) {
		super(turtle, model, DEFAULT_ARGS);
	}
}
