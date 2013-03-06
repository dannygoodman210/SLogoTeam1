package functions;

import backEnd.Executable;
import backEnd.Instruction;
import backEnd.Model;

public abstract class Function implements Executable {

    private Model myModel;
    private int inputNum; 

    public Function (int num, Model model) {
        myModel = model;
        inputNum = num;
    }
    
    public abstract double execute (Instruction toExecute);
    
    	
    public int getArgs () {
        return inputNum;
    }
  
   
    
    public double getReturnValue(Instruction toExectue){
    	return myModel.process(toExectue);
    }
    

}
