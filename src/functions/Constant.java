package functions;

import backEnd.Executable;
import backEnd.Instruction;

/**
 * 
 * @author Francesco Agosti, Eunsu Ryu, Challen Herzberg-Brovold
 *
 *
 */
public class Constant implements Executable {

    private int myValue;
    
    /**
     * 
     * @param constant 
     */
    public Constant(int constant) {
        myValue = constant;
    }
    
    /**
     * @param toExecute 
     */
    public double execute(Instruction toExecute) {
        return myValue;
    }
    
    /**
     * @return string
     */
    public String toString() {
        return myValue + "";
    }
}
