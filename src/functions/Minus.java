package functions;

import backEnd.Model;

public class Minus extends MathFunction {
    
    private static final int DEFAULT_ARGS = 1;
    
    public Minus (Model model) {
        super(model, DEFAULT_ARGS);
    }
    
    @Override
    public double execute (String[] input) {
        return -getValue(input);
    }

}
