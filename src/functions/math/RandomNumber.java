package functions.math;

import backEnd.Model;
import java.util.Random;
import functions.Function;

import functions.Function;

public class RandomNumber extends Function {
    
    
    public RandomNumber(Model model) {
        super(model);
    }
    @Override
    public double execute (String[] input) {
        Random rand = new Random();
        int value = (int)getValue(input);
        return rand.nextInt(value);       
    }

}
