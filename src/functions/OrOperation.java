package functions;

import backEnd.Model;

public class OrOperation extends MathFunction {

    public OrOperation (Model model) {
        super(model);

    }

    @Override
    public double execute (String[] input) {
        double[] values = getValue(input, 2);
        if(values[0] != 0 || values[0] != 0) {
            return 1;
        }
        return 0;
    }
}
