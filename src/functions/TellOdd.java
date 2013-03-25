package functions;

import backEnd.Instruction;
import backEnd.Model;

public class TellOdd extends Function {
	
	public TellOdd(Model model){
		super(model);
	}
	
	public double execute(Instruction toExecute){
		return getTurtleList().activateOdd();
		
	}

}
