package functions;

public class Sum extends MathFunction {

    //At some point, this function really should return something for the workspace to print
    @Override
    public String execute (String[] input) {
        double[] values = getValues(input);
        double result = values[0] + values[1];
        return result + "";
    }

}
