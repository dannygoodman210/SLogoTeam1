package functions.math;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

public class Remainder extends Function {

    public Remainder (Model model) {
        super(model);
    }
    @Override
    public double execute (Instruction toExecute) {
        int numerator = (int) getReturnValue(toExecute);
        int denominator = (int)getReturnValue(toExecute);
        return numerator%denominator;
        
    }

}
