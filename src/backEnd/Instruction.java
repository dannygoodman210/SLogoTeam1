package backEnd;

import java.util.ArrayList;
import java.util.List;

public class Instruction {
	
	List<String> myInstruction;
	
	public Instruction( ){
		
		myInstruction = new ArrayList<String>();
		
		
	}

	public Instruction progress(){
		//return the rest of list after a constant occurs
		
		return new Instruction();
	}
	
	public Instruction getNextChunk(){
		
		return new Instruction();
	}
	
	
}
