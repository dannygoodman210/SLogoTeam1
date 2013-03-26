package functions;

import backEnd.Executable;
import backEnd.Instruction;

/**
 * This class represents a constant.
 * @author Francesco Agosti, Eunsu (Joe) Ryu, Challen Herzberg-Brovold
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
