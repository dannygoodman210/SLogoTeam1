package functions;

import backEnd.Model;

public class Quotient extends MathFunction {

    public Quotient (Model model) {
        super(model);
    }
    @Override
    public double execute (String[] input) {
        double[] values = getValue(input, 2);
        return values[0]/values[1];
        
    }

}
