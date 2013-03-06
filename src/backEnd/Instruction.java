package backEnd;

import java.util.ArrayList;
import java.util.List;

public class Instruction {
	
	List<String> myInstruction;
	
	public Instruction(String[] arguments){
		loadInstruction(arguments);

	}
	
	private void loadInstruction(String[] arguments){
		myInstruction = new ArrayList<String>();
		for(int i = 0 ; i < arguments.length ; i++){
			myInstruction.add(arguments[i]);
		}
	}

	public Instruction progress(){
		myInstruction = myInstruction.subList(1, myInstruction.size());
		return this;
	}
	
	
	public String get(int index){
		return myInstruction.get(index);	
	}
	
	public int length(){
		return myInstruction.size();
	}
	
	public String toString(){
		String a = "";
		for(String b: myInstruction){
			a+=b;
		}
		return a;
	}
	
	
}
