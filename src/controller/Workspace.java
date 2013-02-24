package controller;

import backEnd.Model;
import backEnd.Turtle;
import frontEnd.Canvas;
import java.util.Observable;
import java.util.Observer;


public class Workspace implements Observer {

    private Canvas myView;
    private Model myModel;

    public Workspace (Canvas view) {
        myView = view;
        myModel = new Model(this);
    }

    @Override
    public void update (Observable arg0, Object changedTurtle) {
        myView.updateTurtle((Turtle) changedTurtle);
    }

    public void sendInput (String text) {
        // TODO Auto-generated method stub

    }

}
