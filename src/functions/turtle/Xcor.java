package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;


public class Xcor extends Function {

    private static final int INPUT_VALUES = 0;
    
    public Xcor(Model model) {
        super(model, INPUT_VALUES);
    }

    @Override
    public double execute (Instruction toExecute) {
        return getModel().getLastTurtle().getLocation().x;
    }
}
