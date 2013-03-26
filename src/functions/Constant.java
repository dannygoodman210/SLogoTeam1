package functions;

import backEnd.Executable;
import backEnd.Instruction;

/**
 * 
 * @author Francesco Agosti
 *
 *
 */
public class Constant implements Executable {

    private int myValue;
    
    /**
     * simple constant initialization
     * @param constant 
     */
    public Constant(int constant) {
        myValue = constant;
    }
    
    /**
     * Returns the integer value myValue;
     * @param toExecute 
     */
    public double execute(Instruction toExecute) {
        return myValue;
    }
    
    /**
     * Converts myValue to a string and returns.
     * @return string
     */
    public String toString() {
        return myValue + "";
    }
}
