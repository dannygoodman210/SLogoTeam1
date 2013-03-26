package functions.block;

import functions.Constant;
import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

public class For extends Function {

    private static final int DEFAULT_INPUTS = 2;
    
    public For(Model model){
        super(model, DEFAULT_INPUTS);
    }

    @Override
    public double execute(Instruction toExecute){
    	String variable = toExecute.get(0);
        toExecute.progress();
        int start = (int) getReturnValue(toExecute);
        int end = (int) getReturnValue(toExecute);
        int increment = Integer.parseInt(toExecute.get(0));
        toExecute.progress();
        
        Instruction blockToExecute = toExecute.block();
        
        int iter = start;
        while (iter <= end) {
        	getModel().getMap().put(variable, new Constant(iter));
        	executeBlock(blockToExecute);
        	iter += increment;
        }
        return 0;


    }

}
