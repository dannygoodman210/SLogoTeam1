package functions;

public class Minus extends MathFunction {
    
    public static final int CUT = 2;
    
    public Minus () {
        super(CUT);
    }
    
    @Override
    public String execute (String[] input) {
        double value = -Double.parseDouble(input[1]);
        return value + "";
    }

}
