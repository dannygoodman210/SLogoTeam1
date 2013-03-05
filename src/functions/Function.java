package functions;

import backEnd.Model;
import java.util.*;

public abstract class Function {
    
    private static final int DEFAULT_CUT = 2;
    private int cutNumber;
    private Model myModel;
    
    public Function(Model model){
    	this(DEFAULT_CUT, model);
    }
    
    public Function (int cut, Model model) {
        cutNumber = cut;
        myModel = model;
    }
    
    public abstract double execute (String[] input);
    
    public List<Double> getValue (String[] input) {
        List<Double> values = new ArrayList();
        if(!myModel.getMap().containsKey(input[1])) {
            for(int i = 1; i < cutNumber; i++) {
                values.add(Double.parseDouble(input[i]));
            }
            return values;
        }
        values.add(myModel.getMap().get(input[1]).execute(newArray(input,1)));
        return values;
    }
    
    public String[] getOutput (String[] args) {
        String[] result = null;
        for(int i = 0; i < args.length; i++) {
            if(!myModel.getMap().containsKey(args[i])) {
                result = newArray(args, i + 1);
                
            }
        }
        return result;
    }
    
    private String[] newArray (String[] array, int overlap) {
        String[] output = new String[array.length - overlap];
        for(int i = overlap; i < array.length; i++) {
            output[i-overlap] = array[i];
        }
        return output;
    }
}
