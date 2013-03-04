package frontEnd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import backEnd.Turtle;
import controller.Workspace;


/**
 * Canvas Class extends JPanel. Contains three areas: CommandPrompt Panel, Command History TextArea,
 * and TurtleView Component. CommandPrompt Panel contains command TextArea.
 * 
 * 
 * @author Danny Goodman, David Le
 * 
 */
public class Canvas extends JPanel {

    // default serialization ID
    private static final long serialVersionUID = 1L;
    private static final String BEGIN_LINE = "> ";
    private static final String NEW_LINE = "\n";
    private static final String TEXT_SUBMIT = "text-submit";
    private static final String INSERT_BREAK = "insert-break";
    private static final String FILE_MENU = "File";
    private static final String USER_DIR = "user.dir";
    private static final String NEW_WORKSPACE = "New Worksapce";
    private static final String OPEN_FILE = "Open File";
    private static final String EXIT_PROGRAM = "Quit";
    private static final int COMMAND_HEIGHT = 4;
    private static final int COMMAND_WIDTH = 65;
    private static final int HISTORY_HEIGHT = 31;
    private static final int HISTORY_WIDTH = 20;
    private static final String CLEAR_NAME = "Clear";

    private JFileChooser myChooser;
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
        // make file chooser
        myChooser = new JFileChooser(USER_DIR);
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

    /**
     * Writes text into the history panel
     * 
     * @param text - string to be printed
     */
    public void writeHistory (String text) {
        String[] commandLines = text.split(NEW_LINE);
        for (String command : commandLines) {
            myHistoryView.append(BEGIN_LINE + command + NEW_LINE);
        }
    }

    private Component makeTurtleView () {
        myTurtleView = new TurtleView();
        return myTurtleView;
    }

    private JComponent makeCommandPanel () {
        // create with size in rows and columns
        JPanel result = new JPanel();
        result.add(makeCommandPrompt());
        result.add(makeClearButton());

        return result;
    }

    private Component makeHistoryPanel () {
        myHistoryView = new JTextArea(HISTORY_HEIGHT, HISTORY_WIDTH);
        return new JScrollPane(myHistoryView);
    }

    // convenience Button
    private JButton makeClearButton () {
        JButton result = new JButton(CLEAR_NAME);
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                myTurtleView.clearTrails();
                myHistoryView.setText("");
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
            private static final long serialVersionUID = 1L;

            public void actionPerformed (ActionEvent e) {
                submitInput();
            }
        });
        return new JScrollPane(myCommandPrompt);
    }

    public JMenuBar makeMenus () {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(makeFileMenu());
        return menuBar;
    }

    private JMenu makeFileMenu () {
        JMenu fileMenu = new JMenu(FILE_MENU);
        fileMenu.add(new AbstractAction(NEW_WORKSPACE) {
            @Override
            public void actionPerformed (ActionEvent e) {
                // TODO: make workspace
            }
        });
        fileMenu.add(new AbstractAction(OPEN_FILE) {
            @Override
            public void actionPerformed (ActionEvent e) {
                int response = myChooser.showOpenDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    // TODO: process file; throw exception if not working.
                }
            }
        });
        fileMenu.add(new JSeparator());
        fileMenu.add(new AbstractAction(EXIT_PROGRAM) {
            @Override
            public void actionPerformed (ActionEvent e) {
                // clean up; exit.
                System.exit(0);
            }
        });
        return fileMenu;
    }

    private void submitInput () {
        myController.sendInput(myCommandPrompt.getText());
        writeHistory(myCommandPrompt.getText());
        myCommandPrompt.setText("");
    }

}
