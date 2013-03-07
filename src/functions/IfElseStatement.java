package functions;

import java.util.Queue;
import backEnd.Model;
import backEnd.Parser;

public class IfElseStatement extends Function{
    
	
    public IfElseStatement(Model model) {
    	super(model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
    	boolean condition = getModel().performOperation(commandQueue, executing)!=0;
    	if(condition) System.out.println("IF:"); // Delete in the final implementation
    	else System.out.println("ELSEIF: ");// Delete in the final implementation
    	Double output1 = getModel().performOperation(commandQueue, condition);
    	Double output2 = getModel().performOperation(commandQueue, !condition);
    	return condition? output1 : output2;
    }
    
    

    

}
