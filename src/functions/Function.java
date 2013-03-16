package functions;

import backEnd.Executable;
import backEnd.Instruction;
import backEnd.Model;
import backEnd.Turtle;

public abstract class Function implements Executable {

    private static final int DEFAULTINPUTS = 1;
    private Model myModel;
    private int inputNum; 

    public Function(Model model){
        this(DEFAULTINPUTS,model);
    }
    
    public Function (int num, Model model) {
        myModel = model;
        inputNum = num;
    }

    public abstract double execute (Instruction toExecute);
    
    public int getArgs () {
        return inputNum;
    }


    protected Model getModel(){
        return myModel;
    }
    
    protected Turtle getTurtle(){
    	return myModel.getTurtle();
    }

    public double getReturnValue(Instruction toExectue){
        return myModel.process(toExectue);
    }

    public double executeBlock(Instruction blockToExecute){
        return myModel.processInstruction(blockToExecute.clone());
    }
}
