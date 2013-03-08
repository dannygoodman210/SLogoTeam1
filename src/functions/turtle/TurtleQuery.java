package functions.turtle;

import functions.Function;
import backEnd.Model;
import backEnd.Turtle;

public abstract class TurtleQuery extends Function {
	private static final int DEFAULT_ARGS = 0;
	
	public TurtleQuery(Turtle turtle, Model model) {
		super(model);
	}
}
