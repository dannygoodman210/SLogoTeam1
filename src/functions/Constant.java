package functions;

import backEnd.Executable;
import backEnd.Instruction;


public class Constant implements Executable{
	
	int myValue;

	public Constant(int constant){
		myValue = constant;
	}
		

	public double execute(Instruction toExecute) {
		return myValue;
	}
	
	
}
