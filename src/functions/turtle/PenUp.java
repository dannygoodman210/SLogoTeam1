package functions.turtle;

import functions.Function;
import backEnd.Model;
import backEnd.Turtle;

public class PenUp extends Function{
	
	
	public PenUp(Model model){
		super(model);
	}
	
	@Override
	public double execute(String[] input) {
		getTurtle().setPenDown(false);
		return 0;
	}


}
