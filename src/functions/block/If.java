package functions.block;

import functions.Function;
import backEnd.Instruction;
import backEnd.Model;

public class If extends Function {

    private static final int DEFAULT_INPUTS = 2;
    
    public If(Model model){
        super(model, DEFAULT_INPUTS);
    }

    @Override
    public double execute(Instruction toExecute){
        double value = getReturnValue(toExecute);
        Instruction blockToExecute = toExecute.block();
        if(value != 0){
            return executeBlock(blockToExecute);
        }
        else{
            return 0;
        }
    }

}
