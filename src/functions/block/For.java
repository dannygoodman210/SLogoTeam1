package functions.block;

import functions.Constant;
import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

/**
 * Runs the commands for each value specified in the range, i.e., from start up to end, going by increment.
 * @author Eunsu (Joe) Ryu
 *
 */
public class For extends Function {
    
    public For(Model model){
        super(model);
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
