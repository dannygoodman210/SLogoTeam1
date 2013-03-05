package functions.bool;

import functions.MathFunction;
import backEnd.Model;

public class Greater extends MathFunction {

    public Greater (Model model) {
        super(model);
    }

    @Override
    public double execute(String[] input) {
        double[] values = getValue(input, 2);
        if(values[0] > values[1]) {
            return 1;
        }
        return 0;
    }
}
