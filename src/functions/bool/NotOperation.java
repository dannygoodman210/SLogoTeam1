package functions.bool;

import functions.Function;
import backEnd.Model;

public class NotOperation extends Function {
    
    
    public NotOperation(Model model) {
        super(model);

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
