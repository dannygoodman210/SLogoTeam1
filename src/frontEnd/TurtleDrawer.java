package frontEnd;

import java.awt.Graphics;
import util.Location;


public interface TurtleDrawer {

    public void drawBody (Graphics pen, Location start, Location finish, double heading);

    public void addTrail (Location start, Location finish);

    public void clearTrail ();

    public void drawTrail (Graphics pen);
}
