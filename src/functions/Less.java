package functions;

import backEnd.Model;

public class Less extends MathFunction {

    public Less (Model model) {
        super(model);
    }

    @Override
    public double execute(String[] input) {
        double[] values = getValue(input, 2);
        if(values[0] < values[1]) {
            return 1;
        }
        return 0;
    }
}
