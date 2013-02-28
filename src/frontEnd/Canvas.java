package frontEnd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import backEnd.Turtle;
import controller.Workspace;


public class Canvas extends JPanel {

    // default serialization ID
    private static final long serialVersionUID = 1L;
    private static final String BUTTON_NAME = "Enter";
    private static final String BEGIN_LINE = "> ";
    private static final String NEW_LINE = "\n";
    private static final String TEXT_SUBMIT = "text-submit";
    private static final String INSERT_BREAK = "insert-break";
    private static final int COMMAND_HEIGHT = 4;
    private static final int COMMAND_WIDTH = 60;
    private static final int HISTORY_HEIGHT = 30;
    private static final int HISTORY_WIDTH = 20;
    private static final String CLEAR_NAME = "Clear";
    private Workspace myController;
    private TurtleView myTurtleView;
    private JTextArea myCommandPrompt;
    private JTextArea myHistoryView;

    public Canvas (Dimension size) {
        // set size (a bit of a pain)
        setPreferredSize(size);
        setSize(size);
        // prepare to receive input
        setFocusable(true);
        requestFocus();
        setInputListeners();
        add(makeTurtleView(), BorderLayout.CENTER);
        myController = new Workspace(this);
        add(makeHistoryPanel(), BorderLayout.EAST);
        add(makeCommandPanel(), BorderLayout.SOUTH);
        // size and display the GUI
        setVisible(true);
    }

    private void setInputListeners () {
        // TODO Auto-generated method stub

    }

    public void updateTurtle (Turtle changedTurtle) {
        System.out.println("Turtle Changed!");
        myTurtleView.addToQueue(new Turtle(changedTurtle));
    }

    private Component makeTurtleView () {
        myTurtleView = new TurtleView();
        return myTurtleView;
    }

    private JComponent makeCommandPanel () {
        // create with size in rows and columns
        JPanel result = new JPanel();
        result.add(makeCommandPrompt());
        result.add(makePassStringButton());
        result.add(makeClearButton());

        return result;
    }

    private Component makeHistoryPanel () {
        myHistoryView = new JTextArea(HISTORY_HEIGHT, HISTORY_WIDTH);
        return new JScrollPane(myHistoryView);
    }

    private JButton makePassStringButton () {
        JButton result = new JButton(BUTTON_NAME);
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                submitInput();
            }
        });
        return result;
    }
    
    private JButton makeClearButton () {
        JButton result = new JButton(CLEAR_NAME);
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                myTurtleView.clearTrails();
            }
        });
        return result;
    }

    private JComponent makeCommandPrompt () {
        myCommandPrompt = new JTextArea(COMMAND_HEIGHT, COMMAND_WIDTH);
        InputMap input = myCommandPrompt.getInputMap();
        KeyStroke enter = KeyStroke.getKeyStroke("ENTER");
        KeyStroke shiftEnter = KeyStroke.getKeyStroke("shift ENTER");
        input.put(shiftEnter, INSERT_BREAK);
        input.put(enter, TEXT_SUBMIT);
        ActionMap actions = myCommandPrompt.getActionMap();
        actions.put(TEXT_SUBMIT, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            	submitInput();
            }
        });
        return new JScrollPane(myCommandPrompt);
    }
    
    private void submitInput() {
    	myController.sendInput(myCommandPrompt.getText());
    	writeHistory(myCommandPrompt.getText());
        myCommandPrompt.setText("");
    }

    public void writeHistory (String text) {
        String[] commandLines = text.split(NEW_LINE);
        for(String command : commandLines) {
        	myHistoryView.append(BEGIN_LINE + command + NEW_LINE);
        }
    }

}
