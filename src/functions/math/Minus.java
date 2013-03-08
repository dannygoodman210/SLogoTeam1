package functions.math;

import functions.Function;
import backEnd.Model;

public class Minus extends Function {
    
    private static final int DEFAULT_ARGS = 1;
    
    public Minus (Model model) {
        super(model);
    }
    
    @Override
    public double execute (String[] input) {
        return -getValue(input);
    }

}
