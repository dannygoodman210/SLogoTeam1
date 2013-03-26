package functions.turtle;

import functions.Function;
import backEnd.Model;
import backEnd.Turtle;

/**
 * General function for all turtle queries
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public abstract class TurtleQuery extends Function {
	
	public TurtleQuery(Turtle turtle, Model model) {
		super(model);
	}
}
