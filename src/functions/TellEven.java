package functions;

import backEnd.Instruction;
import backEnd.Model;

public class TellEven extends Function{

	
	public TellEven(Model model){
		super(model);
	}
	
	public double execute(Instruction toExecute){
		return getTurtleList().activateEven();
		
	}
}
