package functions.math;

import backEnd.Model;

import java.util.Queue;
import java.util.Random;

import functions.MathFunction;

public class RandomNumber extends MathFunction {
   
    
    public RandomNumber(Model model) {
        super(model);
    }
    
    /**
     * CAN BE MADE SHORTER. The println() functions are included for the testing purposes.
     * Pleas REMOVE them in the actual implementation. Most execute() methods can be reduced to one-liners.
     * USE COMMENTED CODE FOR FINAL IMPLEMENTATION
     */
    public Double execute(Queue<String> commandQueue, boolean executing) throws Exception {
//    	return executing? Double.valueOf(new Random().nextInt(getModel().performOperation(commandQueue, executing).intValue()) ) : null;
    	
        int value = getModel().performOperation(commandQueue, executing).intValue();
        double rand = new Random().nextInt(value);
        if (executing) {
        	System.out.println(" RANDOM: " + value + ": " + rand);
            return Double.valueOf(rand);       
        } else return null;
        
    }

}
