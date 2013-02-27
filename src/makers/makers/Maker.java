package makers;

import functions.Function;

public abstract class Maker {
    
    public abstract Function make (String s);
    
    /**
     * This method is to return the string that can be used to keep 
     * carrying out commands
     * @param s to cut
     * @return string with the rest of the commands
     */
    public abstract String cutString (String s);
}
