package functions;

import java.util.Queue;
import backEnd.Executable;
import backEnd.Model;

public abstract class Function implements Executable {
    private Model myModel;


    public Function (Model model) {
        myModel = model;
    }
       	 
    protected Model getModel(){
    	return myModel;
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     */
    public abstract double execute (Queue<String> commandQueue) throws Exception;
    

    

}
