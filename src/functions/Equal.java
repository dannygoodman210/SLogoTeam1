package functions;

import backEnd.Model;

public class Equal extends MathFunction {

    public Equal (Model model) {
        super(model);
    }
    @Override
    public double execute(String[] input) {
        double[] values = getValue(input, 2);
        if(values[0] == values[1]) {
            return 1;
        }
        return 0;
    }
}
