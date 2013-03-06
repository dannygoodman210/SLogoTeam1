package functions.turtle;

import functions.TurtleFunction;
import backEnd.Instruction;
import backEnd.Model;
import backEnd.Turtle;

public class Left extends TurtleFunction {
    
    public Left (Turtle turtle, Model model) {
        super(turtle, model);
    }

    @Override
    public double execute (Instruction toExecute) {
        double angle = getReturnValue(toExecute);
        getTurtle().rotate(angle);
        return angle;
    }
}
