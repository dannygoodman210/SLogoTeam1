package util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * Holds a list of ten Colors. Colors can be set by outside functions.
 * 
 * @author Danny Goodman
 * 
 */
public class Palette {

    private List<Color> myColors;

    /**
     * Constructor creates a new Default Palette.
     */
    public Palette () {
        myColors = makeDefaultPalette();
    }

    /**
     * Constructor creates a copy of another Palette.
     * 
     * @param other
     */
    public Palette (Palette other) {
        myColors = new ArrayList<Color>();
        for (Color c : other.myColors) {
            myColors.add(new Color(c.getRGB()));
        }
    }

    /**
     * Get Color at certain index. Throws exception that can be caught and displayed.
     * 
     * @param colorIndex
     * @return Color at colorIndex
     * @throws IndexOutOfBoundsException
     */
    public Color getColor (int colorIndex) throws IndexOutOfBoundsException {
        return myColors.get(colorIndex);
    }

    /**
     * Creates a Color from the given rgb values and sets at the given index.
     * Throws exception to be displayed later.
     * 
     * @param colorIndex
     * @param r
     * @param g
     * @param b
     * @throws IndexOutOfBoundsException
     */
    public void setColor (int colorIndex, int r, int g, int b) throws IndexOutOfBoundsException {
        myColors.set(colorIndex, new Color(r, g, b));
    }

    // makes a default palette.
    private List<Color> makeDefaultPalette () {
        List<Color> palette = new ArrayList<Color>();
        palette.add(Color.BLACK);   
        palette.add(Color.WHITE);   
        palette.add(Color.RED);     
        palette.add(Color.GREEN);   
        palette.add(Color.BLUE);    
        palette.add(Color.YELLOW);  
        palette.add(Color.CYAN);    
        palette.add(Color.MAGENTA); 
        palette.add(Color.ORANGE);  
        palette.add(Color.PINK);    
        return palette;
    }

}
