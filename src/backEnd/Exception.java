package backEnd;

import functions.Function;

public class Exception {
    
    private Model myModel;
        
    public Exception (Model model) {
        myModel = model;
    }
    
    public boolean checkForException (Instruction toCheck) {
        while (toCheck.length() > 0) {
            if(!checkInput(toCheck)){
                return false;
            }
            if(toCheck.length() > 0){
                toCheck.progress();
            }
        }
        return true;
    }
      
    private boolean checkInput (Instruction toCheck) {
        if (isNumber(toCheck)){
            return true;
        }
        if (isBlock(toCheck)){
            return checkForException(toCheck.block());
        }
        if (!isFunction(toCheck)){
            return false;
        }
        Function function = (Function) myModel.get(toCheck.get(0));
        for (int i = 0; i < function.getInputNum(); i++){
             if(!checkInput(toCheck.progress())){
                 return false;
             }
        }
        return true;
    }

    private boolean isNumber(Instruction toCheck) {
        try {
            Integer.parseInt(toCheck.get(0));
            return true;
        } catch(NumberFormatException e){
            return false;
        }        
    }
    
    private boolean isFunction(Instruction toCheck) {
        if(myModel.getMap().contains(toCheck.get(0))){
            return true;
        }
        return false;
    }
    
    private boolean isBlock(Instruction toCheck){
        return toCheck.get(0).equals("[");
    }
}