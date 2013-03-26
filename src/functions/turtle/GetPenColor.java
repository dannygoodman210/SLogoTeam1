package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

public class GetPenColor extends Function {

    public GetPenColor(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
    	return getModel().getLastTurtle().getPenColorIndex();
    }
}
