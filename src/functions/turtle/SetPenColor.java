package functions.turtle;

import backEnd.Model;
import backEnd.Turtle;


/**
 * Sets the pen color
 * 
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 * 
 */
public class SetPenColor extends TurtleFunction {

    private static final int INPUT_VALUES = 1;
    private static final int BIGGEST_INDEX = 9;

    public SetPenColor (Model model) {
        super(model, INPUT_VALUES);
    }

    @Override
    public void process (Turtle turtle, double[] values) {
        int colorIndex = (int) values[0];
        if (colorIndex <= BIGGEST_INDEX && colorIndex >= 0) {
            turtle.setPenColorIndex(colorIndex);
        }
        else {
            getModel().showErrorMsg("ColorIndex");
        }
    }
}
