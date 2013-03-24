package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import functions.Function;

public class Ycor extends Function {

    public Ycor(Model model) {
        super(model);
    }


    @Override
    public double execute(Instruction toExecute) {
        return getModel().getLastTurtle().getLocation().y;
    }
}
