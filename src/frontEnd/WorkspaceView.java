package frontEnd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import backEnd.Turtle;

import controller.Controller;

/**
 * WorkspaceView contains all of the views necessary for a single workspace tab: command prompt, history,
 * and the turtle views; also responsible for instantiating the workspace's turtle.
 * 
 * @author David Le, Danny Goodman
 */
@SuppressWarnings("serial")
public class WorkspaceView extends JPanel {
	
    private static final int COMMAND_HEIGHT = 4;
    private static final int COMMAND_WIDTH = 65;
    private static final int HISTORY_HEIGHT = 31;
    private static final int HISTORY_WIDTH = 20;
    private static final String FRONTEND_RESOURCE = "resources.FrontEnd";
	
    private Canvas myView;
    private TurtleView myTurtleView;
    private JTextArea myCommandPrompt;
    private JTextArea myHistoryView;
    private ResourceBundle myResources;
    
    /**
     * Constructs WorkspaceView and adds the views necessary per tab
     * 
     * @param view which workspace is connected to
     */
    public WorkspaceView (Canvas view) {
    	myView = view;
        myResources = ResourceBundle.getBundle(FRONTEND_RESOURCE);
    	setLayout(new BorderLayout());
        add(makeTurtleView(), BorderLayout.CENTER);
        add(makeHistoryPanel(), BorderLayout.EAST);
        add(makeCommandPanel(), BorderLayout.SOUTH);
    }
    
    /**
     * Instantiates the turtle that will be displayed in this workspace
     */
    public void addDimensionToModel () {
        getController().addDimension();
    }
    
    /**
     * Instantiates the turtle view that will be displayed in this workspace
     * 
     * @return turtle view to be instantiated
     */
	private Component makeTurtleView () {
        myTurtleView = new TurtleView();
        return myTurtleView;
    }

    /**
     * Instantiates the history view that will be displayed in this workspace
     * 
     * @return history view to be instantiated
     */
    private Component makeHistoryPanel () {
        myHistoryView = new JTextArea(HISTORY_HEIGHT, HISTORY_WIDTH);
        return new JScrollPane(myHistoryView);
    }
    
    /**
     * Instantiates the command view (includes prompt + clear button) that will be 
     * displayed in this workspace
     * 
     * @return command view to be instantiated
     */
    private JComponent makeCommandPanel () {
        // create with size in rows and columns
        JPanel result = new JPanel();
        result.add(makeCommandPrompt());
        result.add(makeClearButton());

        return result;
    }
    
    /**
     * Creates the clear button used to clear all trails
     * 
     * @return clear button to be made
     */
    // convenience Button
    private JButton makeClearButton () {
        JButton result = new JButton(myResources.getString("Clear"));
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                myTurtleView.clearTrails();
                myHistoryView.setText(myResources.getString("Blank"));
            }
        });
        return result;
    }

    /**
     * Makes the command prompt which the user will type into
     * 
     * @return command prompt to be made
     */
    private JComponent makeCommandPrompt () {
        myCommandPrompt = new JTextArea(COMMAND_HEIGHT, COMMAND_WIDTH);
        InputMap input = myCommandPrompt.getInputMap();
        KeyStroke enter = KeyStroke.getKeyStroke(myResources.getString("EnterKey"));
        KeyStroke shiftEnter = KeyStroke.getKeyStroke(myResources.getString("ShiftEnterKey"));
        input.put(shiftEnter, myResources.getString("InsertBreak"));
        input.put(enter, myResources.getString("Submit"));
        ActionMap actions = myCommandPrompt.getActionMap();
        actions.put(myResources.getString("Submit"), new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed (ActionEvent e) {
                getController().sendInput(myCommandPrompt.getText());
                writeHistory(myCommandPrompt.getText());
                myCommandPrompt.setText(myResources.getString("Blank"));
            }
        });
        return new JScrollPane(myCommandPrompt);
    }
    
    /**
     * Returns turtle view corresponding to this workspace
     * 
     * @return turtle view corresponding to this workspace
     */
    public TurtleView getTurtleView () {
    	return myTurtleView;
    }
    
    /**
     * Returns command prompt corresponding to this workspace
     * 
     * @return command prompt corresponding to this workspace
     */
    public JTextArea getCommandPrompt () {
    	return myCommandPrompt;
    }
    
    /**
     * Returns history view corresponding to this workspace
     * 
     * @return history view corresponding to this workspace
     */
    public JTextArea getHistoryView () {
    	return myHistoryView;
    }
    
    /**
     * Fetches the controller from the model
     * 
     * @return controller
     */
    private Controller getController () {
    	return myView.getController();
    }
    
    /**
     * Passes a copy of the changedTurtle to the TurtleView. Called by Workspace's Observer method.
     * 
     * @param changedTurtle
     */
    public void updateTurtle (Turtle changedTurtle) {
        myTurtleView.addToQueue(new Turtle(changedTurtle));
    }
    
    /**
     * Writes text into the history panel
     * 
     * @param text - string to be printed
     */
    public void writeHistory (String text) {
        String[] commandLines = text.split(myResources.getString("NewLine"));
        for (String command : commandLines) {
            myHistoryView.append(myResources.getString("BeginLine") + command + myResources.getString("NewLine"));
        }
    }
}
