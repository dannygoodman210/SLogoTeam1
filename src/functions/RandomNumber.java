package functions;

import java.util.Random;

public class RandomNumber extends MathFunction {

    @Override
    public void execute (String[] input) {
        Random rand = new Random();
        int value = Integer.parseInt(input[1]);
        double result = rand.nextInt(value);
    }

}
