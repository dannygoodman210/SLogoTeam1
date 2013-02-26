package functions;

import backEnd.Model;

public class Repeat extends Function{
    private String myCommands;
    private Model myModel;
    private int myReps;
    
    public Repeat (Model model, int reps, String commands) {
        myModel = model;
        myReps = reps;
        myCommands = commands;
    }
    
    @Override
    public double execute () {
        return 0;
    }
}
