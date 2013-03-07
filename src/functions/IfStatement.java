package functions;

import java.util.Queue;
import backEnd.Model;

public class IfStatement extends Function{
	/**
     * Handles if statements
     * @author Eunsu Ryu
     */
	
    public IfStatement(Model model) {
    	super(model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
    	boolean condition = getModel().performOperation(commandQueue, executing) != 0;
    	if(condition) System.out.println("IF: " ); // Delete in the final implementation
		return getModel().performOperation(commandQueue, condition);
    }
    
    

    

}
