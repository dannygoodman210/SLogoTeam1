package functions.block;

import functions.Constant;
import functions.Function;
import backEnd.Instruction;
import backEnd.Model;


/**
 * Runs the commands for each value specified in the range, i.e., from 0 up to (limit - 1). 
 * @author Eunsu (Joe) Ryu
 *
 */
public class DoTimes extends Function {

    
    public DoTimes(Model model){
        super(model);
    }

    @Override
    public double execute(Instruction toExecute){
    	String variable = toExecute.get(0);
        toExecute.progress();
        int numReps = (int) getReturnValue(toExecute);
        Instruction blockToExecute = toExecute.block();
        for (int i = 0; i < numReps; i++) {
        	getModel().getMap().put(variable, new Constant(i));
        	executeBlock(blockToExecute);
        }
        return 0;

    }

}
