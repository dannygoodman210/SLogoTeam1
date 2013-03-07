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
     */
    public double execute(Queue<String> commandQueue) throws Exception {
        int value = (int)getModel().performOperation(commandQueue);
        double rand = new Random().nextInt(value);
        System.out.println(" RANDOM: " + value + ": " + rand);
        return rand;       
    }

}
