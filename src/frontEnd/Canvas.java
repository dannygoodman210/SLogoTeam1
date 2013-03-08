package frontEnd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
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

@SuppressWarnings("serial")
public class Canvas extends JPanel {

    // default serialization ID
    private static final long serialVersionUID = 1L;
    private static final String FRONTEND_RESOURCE = "resources.FrontEnd";

    private JFileChooser myChooser;
    private Workspace myController;
    private JTabbedPane myWorkspaces;
    private TurtleView myTurtleView;
    private JTextArea myCommandPrompt;
    private JTextArea myHistoryView;
    private ResourceBundle myResources;

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
        myResources = ResourceBundle.getBundle(FRONTEND_RESOURCE);
        myWorkspaces = new JTabbedPane();
        add(myWorkspaces);
        myWorkspaces.add("Workspace", makeWorkspace());
        myController = new Workspace(this);
        // make file chooser
        myChooser = new JFileChooser(myResources.getString("UserDirectory"));
        // size and display the GUI
        setVisible(true);
    }
    
    private WorkspaceView makeWorkspace () {
    	WorkspaceView workspace = new WorkspaceView(this);
        return workspace;
    }
    
    public WorkspaceView getWorkspace () {
    	WorkspaceView activeWorkspace = (WorkspaceView) myWorkspaces.getSelectedComponent();
    	return activeWorkspace;
    }
    
    public int getWorkspaceNum () {
    	return myWorkspaces.getSelectedIndex();
    }

    /**
     * Passes a copy of the changedTurtle to the TurtleView. Called by Workspace's Observer method.
     * 
     * @param changedTurtle
     */
    public void updateTurtle (Turtle changedTurtle) {
        getWorkspace().updateTurtle(changedTurtle);
    }

    /**
     * Writes text into the history panel
     * 
     * @param text - string to be printed
     */
    public void writeHistory (String text) {
        String[] commandLines = text.split(myResources.getString("NewLine"));
        for (String command : commandLines) {
            myHistoryView.append(myResources.getString("BeginLine") + command +
                                 myResources.getString("NewLine"));
        }
    }

    public JMenuBar makeMenus () {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(makeFileMenu());
        menuBar.add(makeViewMenu());
        return menuBar;
    }

    private JMenu makeFileMenu () {
        JMenu fileMenu = new JMenu(myResources.getString("FileMenu"));
        fileMenu.add(new AbstractAction(myResources.getString("NewCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
            	myWorkspaces.add("Workspace", makeWorkspace());
            }
        });
        fileMenu.add(new AbstractAction(myResources.getString("OpenCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                int response = myChooser.showOpenDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    // TODO: process file; throw exception if not working.
                }
            }
        });
        fileMenu.add(new JSeparator());
        fileMenu.add(new AbstractAction(myResources.getString("ExitCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                // clean up; exit.
                System.exit(0);
            }
        });
        return fileMenu;
    }

    private JMenu makeViewMenu () {
        JMenu viewMenu = new JMenu(myResources.getString("ViewMenu"));
        viewMenu.add(new AbstractAction(myResources.getString("WarpCommand")) {
            @Override
            public void actionPerformed (ActionEvent e) {
                myTurtleView.toggleWarp();
            }

        });
        return viewMenu;
    }

    public Workspace getController() {
    	return myController;
    }
}
