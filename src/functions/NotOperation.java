package functions;

import backEnd.Model;

public class NotOperation extends MathFunction {
    
    private static final int DEFAULT_ARGS = 1;
    
    public NotOperation(Model model) {
        super(model, DEFAULT_ARGS);

    }

    @Override
    public double execute (String[] input) {
        double value = getValue(input);
        if(value == 0) {
            return 1;
        }
        return 0;
    }
}
