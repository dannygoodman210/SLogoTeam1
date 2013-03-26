package functions.turtle;

import backEnd.Instruction;
import functions.Function;
import backEnd.Model;

/**
 * Returns the heading angle of the turtle
 * @author Eunsu (Joe) Ryu, Challen Herzberg-Brovold, Francesco Agosti
 *
 */
public class Heading extends Function {

    public Heading(Model model) {
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        return getTurtleList().get(getTurtleList().size() - 1).getHeading();
    }

}
