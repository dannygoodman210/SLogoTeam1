package functions;

public abstract class BooleanFunction extends Function {
	/**
	 * For now, this class is identical to MathFunction. 
	 * This class was made to allow extensions to the MathFunction class (e.g. SUM v1 v2 v2 = v1 + v2 + v3) 
	 */
	private static final int CUT = 3;
    
    public BooleanFunction () {
        this(CUT);
    }
    
    public BooleanFunction (int cut) {
        super(cut);
    }
    
    public double[] getValues (String[] input) {
        double[] values =  {Double.parseDouble(input[1]), Double.parseDouble(input[2])};
        return values;
    }	

}
