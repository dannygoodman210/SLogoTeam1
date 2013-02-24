package frontEnd;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


public class TurtleView extends JComponent {

    private static final long serialVersionUID = 1L;
    private boolean isInitialized;

    public TurtleView () {
        setPreferredSize(getMaximumSize());
        setFocusable(true);
        requestFocus();
        isInitialized = false;
    }

    /**
     * Paint the contents of the canvas.
     * 
     * Never called by you directly, instead called by Java runtime
     * when area of screen covered by this container needs to be
     * displayed (i.e., creation, uncovering, change in status)
     * 
     * @param pen used to paint shape on the screen
     */
    @Override
    public void paintComponent (Graphics pen) {
        if (!isInitialized) {
            initialize(pen);
            isInitialized = true;
        }

    }

    public void initialize (Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
    }

}
