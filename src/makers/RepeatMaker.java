package makers;

import backEnd.Model;
import functions.Function;
import functions.Repeat;

public class RepeatMaker extends Maker {
    private Model myModel;
    
    public RepeatMaker (Model model) {
        myModel = model;
    }
    @Override
    public Function make (String s) {
        int reps = Integer.parseInt(s.substring(s.indexOf(' ')));
        String afterBracket = s.substring(s.indexOf('['+1));
        String commands = afterBracket.substring(afterBracket.indexOf(']'));
        return new Repeat(myModel, reps, commands);
    }

}
