package functions;

import backEnd.Executable;
import backEnd.Instruction;
import backEnd.Model;
import backEnd.TurtleList;

public abstract class Function implements Executable {
    
    private Model myModel;
    
    public Function(Model model){
        myModel = model;
    }

    public abstract double execute (Instruction toExecute);
    
    protected Model getModel(){
        return myModel;
    }
    
    protected TurtleList getTurtleList(){
    	return myModel.getTurtleList();
    }
    
    public double getReturnValue(Instruction toExecute){
        return toExecute.execute(getModel().getMap());
    }
}
