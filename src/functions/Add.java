package functions;

import backEnd.Instruction;
import backEnd.Model;
import backEnd.Turtle;

public class Add extends Function {

    public Add (Model model) {
        super(model);
    }
    
    @Override
    public double execute (Instruction toExecute) {
    	int turtleID = getModel().getTurtleListLength();
        getModel().add(new Turtle(getModel().getController(), turtleID));
        return 1;
    }

}
