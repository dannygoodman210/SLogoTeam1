package functions.block;

import functions.Constant;
import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

public class DoTimes extends Function {

    private static final int DEFAULT_INPUTS = 2;
    
    public DoTimes(Model model){
        super(model, DEFAULT_INPUTS);
    }

    @Override
    public double execute(Instruction toExecute){
    	String variable = toExecute.get(0);
        toExecute.progress();
        int numReps = Integer.parseInt(toExecute.get(0));
        toExecute.progress();
        Instruction blockToExecute = toExecute.block();
        for (int i = 0; i < numReps; i++) {
        	getModel().getMap().put(variable, new Constant(i));
        	executeBlock(blockToExecute);
        }
        return 0;

    }

}
