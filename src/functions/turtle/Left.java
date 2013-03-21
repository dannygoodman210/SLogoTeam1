package functions.turtle;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

public class Left extends Function {
    
    public Left (Model model) {
        super(model);
    }

    @Override
    public double execute (Instruction toExecute) {
        double angle = getReturnValue(toExecute);
        getTurtle().rotate(angle);
        return angle;
    }
}
