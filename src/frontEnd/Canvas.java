package frontEnd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import backEnd.Turtle;
import controller.Workspace;


/**
 * Canvas Class extends JPanel. Contains three areas: CommandPrompt Panel, Command History TextArea,
 * and TurtleView Component. CommandPrompt Panel contains command TextArea and "Enter" Button.
 * 
 * 
 * @author Danny Goodman, David Le
 * 
 */
public class Canvas extends JPanel {

    // default serialization ID
    private static final long serialVersionUID = 1L;
    private static final String BUTTON_NAME = "Enter";
    private static final int COMMAND_HEIGHT = 4;
    private static final int COMMAND_WIDTH = 60;
    private static final int HISTORY_HEIGHT = 30;
    private static final int HISTORY_WIDTH = 20;
    private static final String CLEAR_NAME = "Clear";
    private Workspace myController;
    private TurtleView myTurtleView;
    private JTextArea myCommandPrompt;
    private JTextArea myHistoryView;

    /**
     * Canvas object created in Main class. Takes in size of JPanel.
     * Initializes JComponents. Instantiates Workspace.
     * 
     * @param size
     */
    public Canvas (Dimension size) {
        // set size (a bit of a pain)
        setPreferredSize(size);
        setSize(size);
        // prepare to receive input
        setFocusable(true);
        requestFocus();
        add(makeTurtleView(), BorderLayout.CENTER);
        add(makeHistoryPanel(), BorderLayout.EAST);
        add(makeCommandPanel(), BorderLayout.SOUTH);
        myController = new Workspace(this);
        // size and display the GUI
        setVisible(true);
    }

    /**
     * Passes a copy of the changedTurtle to the TurtleView. Called by Workspace's Observer method.
     * 
     * @param changedTurtle
     */
    public void updateTurtle (Turtle changedTurtle) {
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
                myController.sendInput(myCommandPrompt.getText());
                writeHistory(myCommandPrompt.getText());
                myCommandPrompt.setText("");
            }
        });
        return result;
    }

    // Convenience Button
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
        return new JScrollPane(myCommandPrompt);
    }

    protected void writeHistory (String text) {
        // TODO Auto-generated method stub

    }

}
