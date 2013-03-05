package functions;

import backEnd.Model;

public abstract class BooleanFunction extends Function {
    /**
     * For now, this class is identical to MathFunction. 
     * This class was made to allow extensions to the MathFunction class (e.g. SUM v1 v2 v2 = v1 + v2 + v3) 
     */
    private static final int DEFAULT_ARGS = 2;

    public BooleanFunction (Model model) {
        this(model, DEFAULT_ARGS);
    }

    public BooleanFunction (Model model, int num) {
        super(num, model);
    }

}
