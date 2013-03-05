package functions;

import backEnd.Model;

public abstract class Function {

    private static final int DEFAULT_CUT = 2;
    private Model myModel;

    public Function(Model model){
        this(DEFAULT_CUT, model);
    }

    // Cut isn't used, I'm keeping it for now just in case
    public Function (int cut, Model model) {
        myModel = model;
    }

    public abstract double execute (String[] input);

    public double getValue (String[] input) {
        //System.out.println(input.length);
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
            intermediate = getOutput(input);
            input = new String[intermediate.length + 1];
            input[0] = begin;
            for(int j = 1; j < input.length; j++){
                input[j] = intermediate[j - 1];
            }
        }
        return values;
    }
    
    public String[] getOutput (String[] args) {
        String[] result = null;
        for(int i = 0; i < args.length; i++) {
            if(!myModel.getMap().containsKey(args[i])) {
                result = newArray(args, i + 1);
                break;
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
