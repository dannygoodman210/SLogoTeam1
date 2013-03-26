package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;


/**
 * Sets the background color of the workspace
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class SetBackground extends Function {

	public SetBackground(Model model) {
		super(model);
	}

	@Override
	public double execute(Instruction toExecute) {
		int colorIndex = (int)getReturnValue(toExecute);
		getModel().getCurrentWorkspace().setBackground(colorIndex);
		return colorIndex;
	}

}
