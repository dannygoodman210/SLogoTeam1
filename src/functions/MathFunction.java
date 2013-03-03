package functions;

public abstract class MathFunction extends Function {

   private static final int CUT = 3;
    
    public MathFunction () {
        this(CUT);
    }
    
    public MathFunction (int cut) {
        super(cut);
    }
    
    public double[] getValues (String[] input) {
        double[] values =  {Double.parseDouble(input[1]), Double.parseDouble(input[2])};
        return values;
    }
}
