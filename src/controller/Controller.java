package controller;

import backEnd.Instruction;
import backEnd.Model;
import backEnd.Workspace;
import frontEnd.Canvas;
import java.util.Observable;
import java.util.Observer;


/**
 * Workspace object serves as the controller between the model and the view.
 * Implements Observer interface. Observes Turtle object. Observes Workspace object.
 * 
 * @author Danny Goodman, Francesco Agosti, Challen Herzberg-Brovold, Eunsu (Joe) Ryu
 * 
 */
public class Controller implements Observer {

    private Canvas myView;
    private Model myModel;

    /**
     * 
     * @param view 
     */
    public Controller (Canvas view) {
        myView = view;
        myModel = new Model(this);
    }

    /**
     * Called by Observable's notifyObservers method
     * @param arg0 
     * @param arg1 
     */
    @Override
    public void update (Observable arg0, Object arg1) {
        myView.updateWorkspace((Workspace) arg0);
    }

    /**
     * Called by Canvas class when "Enter" button is pressed. Backend implements this to pass
     * the un-parsed text from the controller to the model.
     * 
     * @param text 
     */

    public void sendInput (String text) {
        Instruction commands = myModel.formatString(text);
        myModel.processInstruction(commands);
    }
    
    /**
     * 
     * @return index of controller
     */
    public int getWorkspaceIndex () {
        return myView.getWorkspaceIndex();
    }
    
    /**
     * adds a workspace
     */
    public void addWorkspace () {
        myModel.addWorkspace();
    }
    
    /**
     * sends history
     * @param value 
     */
    public void sendHistory (double value) {
        myView.writeHistory(Double.toString(value));
    }
       
    /**
     * 
     * @param variable 
     * @param toAdd 
     */
    public void sendVariable (String variable, int toAdd) {
        myView.writeVariable(variable, toAdd);
    }
    
    
    /**
     * Send UserDefined function to Canvas
     * 
     * @param name
     * @param params
     */
    public void sendUserDefined (String name, Instruction params) {
        myView.writeUserDefined(name,params);
    }

    /**
     * 
     * @param text sends exception to user
     */
    public void showErrorMsg (String text) {
        myView.showErrorMsg(text);
    }
    
    /**
     * 
     * @param name 
     */
    public void loadFile (String name) {
        myModel.loadFile(name);
    }
    
    /**
     * 
     * @param filePath 
     */
    public void saveFile (String filePath) {
        myModel.saveFile(filePath);  
    }
}
