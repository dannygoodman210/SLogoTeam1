package functions.turtle;

import backEnd.Instruction;
import backEnd.Model;
import backEnd.Turtle;
import backEnd.TurtleList;
import functions.Function;

public abstract class TurtleFunction extends Function {
    
    private int myInputs;
    
    public TurtleFunction (Model model, int values) {
        super(model);
        myInputs = values;
    }
    
    public abstract void process (Turtle turtle, double[] values);
    
    @Override
    public double execute (Instruction toExecute) {
        double[] values = getValues(toExecute);
        TurtleList turtles = getTurtleList();
        for (Integer id: turtles.getActiveIDs()) {
            process(turtles.get(id), values);
        }
        return getReturn(values);
    }
    
    private double getReturn (double[] values) {
        return values[0];
    }
    
    private double[] getValues (Instruction toExecute) {
        double[] values = new double[myInputs];
        for (int i = 0; i < myInputs; i++) {
            values[i] = getReturnValue(toExecute);
        }
        return values;
    }
    
    public boolean checkInput(Instruction toCheck){
        for (int i = 0; i < myInputs; i++) {
            try {
                Integer.parseInt(toCheck.get(0));
                toCheck.progress();
                continue;
            } catch(NumberFormatException e) {   
            }
            TurtleFunction tf = null;
//            try { 
//                tf = (TurtleFunction) getModel().get(toCheck.get(0));
//            } catch(NullPointerException e) {
//                return false;
//            }
            if(getModel().getMap().contains(toCheck.get(0))){
                tf = (TurtleFunction) getModel().get(toCheck.get(0));
            }
            else{
                return false;
            }
            if(!tf.checkInput(toCheck.progress())){
                return false;
            }
        }
        return true;
    }
}
