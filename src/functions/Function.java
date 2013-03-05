package functions;

import backEnd.Model;

public abstract class Function {

    private Model myModel;
    private int inputNum; 

    // Cut isn't used, I'm keeping it for now just in case
    public Function (int num, Model model) {
        myModel = model;
        inputNum = num;
    }

    public abstract double execute (String[] input);

    public double getValue (String[] input) {
        if(!myModel.getMap().containsKey(input[1])) {
            return Double.parseDouble(input[1]);
        }
        return myModel.getMap().get(input[1]).execute(newArray(input, 1));
    }
    
    public double[] getValue (String[] input, int numVals) {
        double[] values = new double[numVals];
        String[] intermediate = null;
        String begin = input[0];
        for(int i = 0; i < numVals; i++) {
            values[i] = getValue(input);
            intermediate = getIntermediate(input);
            input = new String[intermediate.length + 1];
            input[0] = begin;
            for(int j = 1; j < input.length; j++){
                input[j] = intermediate[j - 1];
            }
        }
        return values;
    }
    
    public String[] getIntermediate (String[] input) {
        String[] result = null;
        for (int i = 0; i < input.length; i++) {
            if(!myModel.getMap().containsKey(input[i])) {
                result = newArray(input, i + 1);
                break;
            }
        }
        return result;
    }
    public String[] getOutput (String[] args) {
        String[] result = null;
        int count = 0;
        if(inputNum == 0) {
            return newArray(args, 1);
        }
        for(int i = 0; i < args.length; i++) {
            if(!myModel.getMap().containsKey(args[i])) {
                count++;
                if(count == inputNum) {
                    result = newArray(args, i + 1);
                    break;
                }
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
