package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

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
