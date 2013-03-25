package backEnd;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * A class that takes care of functionality needed for instructions. 
 * @author Francesco Agosti
 *
 */

public class Instruction {

    List<String> myInstruction;

    public Instruction(String[] arguments){
        loadInstruction(arguments);
    }

    public Instruction(List<String> inst){
        myInstruction = inst;
    }

    /**
     * loads an array into myInstruction. 
     * @param arguments
     */
    private void loadInstruction(String[] arguments){
        myInstruction = new ArrayList<String>();
        for(int i = 0 ; i < arguments.length ; i++){
            myInstruction.add(arguments[i]);
        }
    }

    /**
     * A method that moves the instruction forward and modifies it permanently. 
     * Returns the new instruction which is the same as the previous instruction
     * but without the first element. 
     * @return this instruction
     */
    public Instruction progress(){
        myInstruction = myInstruction.subList(1, myInstruction.size());
        return this;
    }

    /**
     * To be called when a "block" (ex: [fd 50 left 40]) is expected.
     * Returns a new instruction with the contents of the block. 
     * Moves main instruction forward to AFTER the block and modifies
     * it permanently. 
     * 
     * @return block to be executed
     */
    public Instruction block(){
        if(!myInstruction.get(0).equals("[")){
            //throw exception
        }
        progress();
        int bracket1Count = 1;
        int bracket2Count = 0;
        List<String> block = new ArrayList<String>();
        for(String ins: myInstruction){
            if(ins.equals("]")){
                bracket2Count++;
            }
            if(bracket1Count == bracket2Count){
                break;
            }
            if(ins.equals("[")){
                bracket1Count++;
            }
            block.add(ins);
        }
        myInstruction = myInstruction.subList(block.size()+1, myInstruction.size());
        return new Instruction(block);
    }

    /**
     * Returns a duplicate of this instruction. 
     * (useful when you need to execute a block multiple times)
     */
    public Instruction clone(){
        return new Instruction(myInstruction);
    }

    /**
     * Returns ith element in the instruction list. 
     * @param index
     * @return string corresponding to element. 
     */
    public String get(int index){
        return myInstruction.get(index);	
    }

    /**
     * @return the length of this instruction.
     */
    public int length(){
        return myInstruction.size();
    }
    
    /**
     * returns a String representation of this instruction.
     */
    public String toString(){
        String a = "";
        for(String b: myInstruction){
            a+=b + " ";
        }
        return a;
    }
}
