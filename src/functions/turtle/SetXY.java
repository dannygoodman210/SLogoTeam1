package functions.turtle;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;
import backEnd.Turtle;

public class SetXY extends Function {

    private static final int DEFAULT_ARGS = 2;
    
    public SetXY(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        double x = getReturnValue(toExecute);
        double y = getReturnValue(toExecute);
        getTurtle().setLocation(x, y);
        return x+y;//NOTE MUST ACTUALLY RETURN DISTANCE
    }

}
