package functions;

import backEnd.Model;

public abstract class BlockFunction extends Function {


    private Model myModel;


    public BlockFunction(Model model){
        myModel = model;
    }

    public Model getModel(){
        return myModel;
    }
}
