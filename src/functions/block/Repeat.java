package functions.block;

import functions.Constant;
import functions.Function;
import backEnd.Instruction;
import backEnd.Model;


public class Repeat extends Function {

	private final String REPCOUNT = ":repcount";
	
    public Repeat (Model model) {
        super(model);
    }

    @Override
    public double execute (Instruction toExecute) {
        double reps = getReturnValue(toExecute);
        Instruction blockToExecute = toExecute.block();
        for(double i = 0 ; i < reps; i++){
        	getModel().getMap().add(REPCOUNT, new Constant((int)i+1));
            executeBlock(blockToExecute);
        }
        return reps;
    }
}
