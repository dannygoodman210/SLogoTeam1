package functions;

public class Difference extends MathFunction {

    //At some point, this function really should return something for the workspace to print
    @Override
    public String execute (String[] input) {
        double[] values = getValues(input);
        double sum = values[0] - values[1];
        //return sum
        return sum + "";
    }
}
