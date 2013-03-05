package functions.math;

import backEnd.Model;
import java.util.Random;

import functions.MathFunction;

public class RandomNumber extends MathFunction {
    
    private static final int DEFAULT_ARGS = 1;
    
    public RandomNumber(Model model) {
        super(model, DEFAULT_ARGS);
    }
    @Override
    public double execute (String[] input) {
        Random rand = new Random();
        int value = (int)getValue(input);
        return rand.nextInt(value);       
    }

}
