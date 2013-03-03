package functions;

import backEnd.Turtle;

public abstract class TurtleQuery extends TurtleFunction {
	private static final int QUERY_CUT = 1;
	public TurtleQuery(Turtle turtle) {
		super(turtle, QUERY_CUT);
	}

	
}
