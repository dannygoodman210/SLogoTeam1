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
        String commands = unBracket(s.substring(s.indexOf('['+1)));
        return new Repeat(myModel, reps, commands);
    }
    
    @Override
    public String cutString (String s) {
        return "";
    }
    
    //unBracket is to get rid of brackets from the string
    public String unBracket (String s) {
        int cutIndex = 0;
        int countOpenBrackets = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                countOpenBrackets++;
            }
            else if (s.charAt(i) == ']') {
                if (countOpenBrackets == 0) {
                    cutIndex = i;
                }
                else {
                    countOpenBrackets--;
                }
            }
        }
        return s.substring(0, cutIndex);
    }

}
