package functions;

import backEnd.Executable;


public class Constant implements Executable{
	
	int myValue;

	public Constant(int constant){
		myValue = constant;
	}
		

	public double execute(String[] input) {
		return myValue;
	}
	
	@Override
	public String[] getOutput(String[] args){
		return new String[0];
	}
	
	
}
