package functions;

public class Quotient extends MathFunction {

    @Override
    public String execute (String[] input) {
        double[] values = getValues(input);
        double result = values[0]/values[1];
        return result + "";
    }

}
