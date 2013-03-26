package functions.block;

import backEnd.Instruction;
import backEnd.Model;
import functions.Constant;
import functions.Function;

public class Repeat extends Function {

    private final String REPCOUNT = ":repcount";

    public Repeat (Model model) {
        super(model);
    }

    @Override
    public double execute (Instruction toExecute) {
        double reps = getReturnValue(toExecute);
        Instruction blockToExecute = toExecute.block();
        for (int i = 0; i < reps; i++) {
            getModel().getMap().put(REPCOUNT, new Constant(i + 1));
            getReturnValue(blockToExecute);
        }
        return reps;
    }
}
