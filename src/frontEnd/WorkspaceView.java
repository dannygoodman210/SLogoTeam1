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
    
    public WorkspaceView (Canvas view) {
    	myView = view;
        myResources = ResourceBundle.getBundle(FRONTEND_RESOURCE);
    	setLayout(new BorderLayout());
        add(makeTurtleView(), BorderLayout.CENTER);
        add(makeHistoryPanel(), BorderLayout.EAST);
        add(makeCommandPanel(), BorderLayout.SOUTH);
    }
    
    public void makeTurtle () {
        getController().addTurtle();
    }
    
	private Component makeTurtleView () {
        myTurtleView = new TurtleView();
        return myTurtleView;
    }

    private Component makeHistoryPanel () {
        myHistoryView = new JTextArea(HISTORY_HEIGHT, HISTORY_WIDTH);
        return new JScrollPane(myHistoryView);
    }
    
    private JComponent makeCommandPanel () {
        // create with size in rows and columns
        JPanel result = new JPanel();
        result.add(makeCommandPrompt());
        result.add(makeClearButton());

        return result;
    }
    
    public TurtleView getTurtleView () {
    	return myTurtleView;
    }
    
    public JTextArea getCommandPrompt () {
    	return myCommandPrompt;
    }
    
    public JTextArea getHistoryView () {
    	return myHistoryView;
    }

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
    
    private Controller getController () {
    	return myView.getController();
    }
}
