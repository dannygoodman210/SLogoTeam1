package functions;

public class Remainder extends MathFunction {

    @Override
    public void execute (String[] input) {
        double[] values = getValues(input);
        double remainder = values[0]%values[1];

    }

}
