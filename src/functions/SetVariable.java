package functions;

import java.util.Queue;
import backEnd.Model;

public class SetVariable extends Function{
    /**
     * Defines variable
     * @author Eunsu Ryu
     */
	
    public SetVariable(Model model) {
    	super(model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     * USE COMMENTED CODE FOR FINAL IMPLEMENTATION
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
    	String variableName = commandQueue.poll();
    	Double value = getModel().performOperation(commandQueue, executing);
//    	return executing? getModel().putNewVariableInDictionary(variableName, value):null;
    	
    	if (executing) {
    		System.out.println(" SET NEW VARIABLE: " + variableName + " = " + value); // Delete in the final implementation
        	return getModel().putNewVariableInDictionary(variableName, value);
    	} else return null;
    	
    }
    
    

    

}
