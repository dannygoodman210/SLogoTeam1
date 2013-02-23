package frontEnd;

import java.awt.Dimension;
import javax.swing.JComponent;
import controller.Workspace;

public class Canvas extends JComponent{
    
    Workspace myWorkspace;
    
    public Canvas (Dimension size) {
        // set size (a bit of a pain)
        setPreferredSize(size);
        setSize(size);
        // prepare to receive input
        setFocusable(true);
        requestFocus();
        setInputListeners();
        myWorkspace = new Workspace(this);
    }

    private void setInputListeners () {
        // TODO Auto-generated method stub
        
    }
    

}
