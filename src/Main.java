import frontEnd.Canvas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;



/**
 * Creates window that can be moved, resized, and closed by the user.
 * 
 * @author Robert C. Duvall
 */
public class Main {
    
    /**
     * title of window
     */
    public static final String TITLE = "SLogo";
    /**
     * default size of window
     */
    public static final Dimension SIZE = new Dimension(900, 630);
    

    private Main() {
    }
    

    /**
     * 
     * @param args 
     */
    public static void main (String[] args) {
    
        // view of user's content
        Canvas display = new Canvas(SIZE);
        // container that will work with user's OS
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add our user interface components
        frame.getContentPane().add(display, BorderLayout.CENTER);
        // make menu bar
        frame.setJMenuBar(display.makeMenus());
        // display them
        frame.pack();
        frame.setVisible(true);
        
    }
}
