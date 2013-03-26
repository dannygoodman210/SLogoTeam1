package functions;

import backEnd.Executable;
import backEnd.Instruction;

/**
<<<<<<< HEAD
 * This class represents a constant.
 * @author Francesco Agosti, Eunsu (Joe) Ryu, Challen Herzberg-Brovold
=======
 * 
 * @author Francesco Agosti
>>>>>>> cd2a2ebc664c523fcd57501b7954329aaf4e6694
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
