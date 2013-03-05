package functions;

import backEnd.Model;

public abstract class MathFunction extends Function {

   private static final int DEFAULT_ARGS = 2;
    
    public MathFunction (Model model) {
        this(model, DEFAULT_ARGS);
    }
    
    public MathFunction (Model model, int num) {
        super(num, model);
    }
}
