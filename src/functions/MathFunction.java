package functions;

public abstract class MathFunction extends Function {

   private static final int CUT = 3;
    
    public MathFunction () {
        super(CUT);
    }
    
    public MathFunction (int cut) {
        super(cut);
    }
}
