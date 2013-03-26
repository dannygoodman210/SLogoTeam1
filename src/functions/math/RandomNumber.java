package functions.math;

import backEnd.Instruction;
import backEnd.Model;
import java.util.Random;
import functions.Function;


/**
 * Generates a random number between 0 and the input
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class RandomNumber extends Function {
    
    public RandomNumber(Model model) {
        super(model);
    }
    @Override
    public double execute (Instruction toExecute) {
        Random rand = new Random();
        int value = (int) getReturnValue(toExecute);
        return rand.nextInt(value);
    }

}
