package functions;

public class Difference extends MathFunction {

    //At some point, this function really should return something for the workspace to print
    @Override
    public void execute (String[] input) {
        double[] values = {Double.parseDouble(input[1]), Double.parseDouble(input[2])};
        double sum = values[0] - values[1];
        //return sum
    }
}
