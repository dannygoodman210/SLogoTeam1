package backEnd;

import functions.turtle.TurtleFunction;

public class Exception {
    
    private Model myModel;
        
    public Exception (Model model) {
        myModel = model;
    }
    
    public boolean checkForException (Instruction toCheck) {
        while (toCheck.length() > 0) {
            TurtleFunction tFunction = (TurtleFunction) myModel.get(toCheck.get(0));
            if(!tFunction.checkInput(toCheck.progress())) {
                return false;
            }    
        }
        return true;
    }
}
