package functions.turtle;

import functions.Function;
import backEnd.Model;
import backEnd.Turtle;

public class Xcor extends Function {
	
	public Xcor(Model model) {
		super(model);
	}

	
	@Override
	public double execute(String[] input) {
		return getTurtle().getLocation().x;
	}

}
