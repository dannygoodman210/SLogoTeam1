package functions;

public class Greater extends BooleanFunction {

	@Override
	public String execute(String[] input) {
		double[] values = getValues(input);
		boolean result = values[0] > values[1];
		return result + "";
	}

}