package controller;

import backEnd.Model;
import backEnd.Turtle;
import frontEnd.Canvas;
import java.util.Observable;
import java.util.Observer;

/**
 * Workspace object serves as the controller between the model and the view.
 * Implements Observer interface. Observes Turtle object.
 * 
 * @author Danny Goodman, Francesco Agosti, Challen Herzberg-Brovold, Eunsu (Joe) Ryu
 *
 */
public class Workspace implements Observer {

    private Canvas myView;
    private Model myModel;

    public Workspace (Canvas view) {
        myView = view;
        myModel = new Model(this);
    }

    /**
     * Called by Observable's notifyObservers method
     */
    @Override
    public void update (Observable arg0, Object arg1) {
        myView.updateTurtle((Turtle) arg0);
    }

    /**
     * Called by Canvas class when "Enter" button is pressed. Backend implements this to pass
     * the un-parsed text from the controller to the model.
     * 
     * @param text
     */
    public void sendInput (String text) {
        String[] commands = myModel.formatString(text);
        myModel.processString(commands);

    }

}
