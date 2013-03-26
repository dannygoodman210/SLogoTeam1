package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

public class GetShapeIndex extends Function {

    public GetShapeIndex(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
    	return getModel().getLastTurtle().getShapeIndex();
    }
}
