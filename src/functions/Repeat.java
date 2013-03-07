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
    public double execute(Queue<String> commandQueue) throws Exception {
    	int numReps = (int)getModel().performOperation(commandQueue);
		Queue<String> copied;
		for (int n = 1; n <numReps; n++) { 
			System.out.println("REPEAT: " + n);
			copied = Parser.copyQueue(commandQueue);
			getModel().performOperation(copied);
		}
		System.out.println("REPEAT: " + numReps);
		getModel().performOperation(commandQueue);
		return numReps;
    }
    
    

    

}
