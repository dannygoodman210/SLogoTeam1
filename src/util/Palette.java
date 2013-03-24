package util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Palette {

    private List<Color> myColors;

    public Palette () {
        myColors = makeDefaultPalette();
    }

    public Color getColor (int colorIndex) throws IndexOutOfBoundsException{
        return myColors.get(colorIndex);
    }

    public void setColor (int colorIndex, int r, int g, int b) throws IndexOutOfBoundsException {
        myColors.set(colorIndex, new Color(r, g, b));
    }

    private List<Color> makeDefaultPalette () {
        List<Color> palette = new ArrayList<Color>();
        palette.add(Color.BLACK);   // 0
        palette.add(Color.WHITE);   // 1
        palette.add(Color.RED);     // 2
        palette.add(Color.GREEN);   // 3
        palette.add(Color.BLUE);    // 4
        palette.add(Color.YELLOW);  // 5
        palette.add(Color.CYAN);    // 6
        palette.add(Color.MAGENTA); // 7
        palette.add(Color.ORANGE);  // 8
        palette.add(Color.PINK);    // 9
        return palette;
    }

}
