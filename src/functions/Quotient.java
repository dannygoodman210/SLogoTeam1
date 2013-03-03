package functions;

public class Quotient extends MathFunction {

    @Override
    public void execute (String[] input) {
        double[] values = getValues(input);
        double sum = values[0]/values[1];

    }

}
