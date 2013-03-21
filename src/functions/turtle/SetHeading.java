package functions.turtle;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

public class SetHeading extends Function {

    public SetHeading(Model model){
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        double angle = getReturnValue(toExecute);
        getTurtle().setHeading(angle);
        return angle;
    }

}
