package backEnd;

import controller.Workspace;

public class Model {

    private Workspace myController;
    private Turtle myTurtle;
    private Interpreter myInterpreter;
    
    public Model(Workspace controller){
        myController = controller;
        myTurtle = new Turtle(myController);
        myInterpreter = new Interpreter();
    }
}
