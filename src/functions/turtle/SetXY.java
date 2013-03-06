package functions.turtle;

import functions.TurtleFunction;
import backEnd.Instruction;
import backEnd.Model;
import backEnd.Turtle;

public class SetXY extends TurtleFunction {

    private static final int DEFAULT_ARGS = 2;
    
    public SetXY(Turtle turtle, Model model) {
        super(turtle, model, DEFAULT_ARGS);
    }

    @Override
    public double execute(Instruction toExecute) {
        double x = getReturnValue(toExecute);
        double y = getReturnValue(toExecute);
        getTurtle().setLocation(x, y);
        return x+y;//NOTE MUST ACTUALLY RETURN DISTANCE
    }

}
