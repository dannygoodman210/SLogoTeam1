package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

public class SetXY extends Function {
    
    public SetXY(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        double x = getReturnValue(toExecute);
        double y = getReturnValue(toExecute);
        getTurtle().setLocation(x, y);
        return x+y;
    }

}
