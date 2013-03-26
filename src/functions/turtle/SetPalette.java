package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

public class SetPalette extends Function {

	public SetPalette(Model model) {
		super(model);
	}

	@Override
	public double execute(Instruction toExecute) {
		int colorIndex = (int)getReturnValue(toExecute);
		int r = (int)getReturnValue(toExecute);
		int g = (int)getReturnValue(toExecute);
		int b = (int)getReturnValue(toExecute);
		getModel().getCurrentWorkspace().setPalette(colorIndex, r, g, b);
		return colorIndex;
	}

}
