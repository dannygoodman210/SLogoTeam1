package functions.math;

import backEnd.Instruction;
import backEnd.Model;
import java.util.Random;
import functions.Function;

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
