package functions;

public class Product extends MathFunction {

    @Override
    public void execute (String[] input) {
        double[] values = getValues(input);
        double sum = values[0] * values[1];

    }

}
