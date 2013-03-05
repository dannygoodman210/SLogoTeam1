package functions.math;

import functions.MathFunction;
import backEnd.Model;

public class Remainder extends MathFunction {

    public Remainder (Model model) {
        super(model);
    }
    @Override
    public double execute (String[] input) {
        double[] values = getValue(input, 2);
        return values[0]%values[1];
        
    }

}
