package functions;

import java.util.Queue;
import backEnd.Model;
import backEnd.Parser;

public class Repeat extends Function{
    
	
    public Repeat(Model model) {
    	super(model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    @Override
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
//    	int numReps = getModel().performOperation(commandQueue, executing).intValue();
//		Queue<String> copied;
//		for (int n = 1; n <numReps; n++) { 
//			copied = Parser.copyQueue(commandQueue);
//			getModel().performOperation(copied, executing);
//		}
//		getModel().performOperation(commandQueue, executing);
//		return executing? Double.valueOf(numReps) : null;
		
		int numReps = getModel().performOperation(commandQueue, executing).intValue();
		Queue<String> copied;
		for (int n = 1; n <numReps; n++) { 
			if(executing) System.out.println("REPEAT: " + n);
			copied = Parser.copyQueue(commandQueue);
			getModel().performOperation(copied, executing);
		}
		if(executing) System.out.println("REPEAT: " + numReps);
		getModel().performOperation(commandQueue, executing);
		return executing? Double.valueOf(numReps) : null;
		
		

    }
    
    

    

}
