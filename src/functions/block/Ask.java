package functions.block;

import backEnd.Instruction;
import backEnd.Model;
import backEnd.TurtleList;
import functions.Function;
import java.util.HashSet;
import java.util.Set;

public class Ask extends Function {
    
    public Ask (Model model) {
        super(model);
    }
    
    @Override
    public double execute (Instruction toExecute) {
        Instruction ids = toExecute.block();
        Set<Integer> idset = getIDs(ids);
        TurtleList turtle = getTurtleList();
        return 0;
    }

    private Set<Integer> getIDs (Instruction toExecute) {
        Set<Integer> ids = new HashSet<Integer>();
        while (toExecute.length() > 0) {
            ids.add((int)getReturnValue(toExecute));
        }
        return ids;
    }
}
