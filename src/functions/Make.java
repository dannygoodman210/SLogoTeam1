package functions;

import backEnd.Instruction;
import backEnd.Model;

public class Make extends Function{

    public Make(Model model){
        super(model);
    }

    @Override
    public double execute(Instruction toExecute) {
        String variable = toExecute.get(0);
        toExecute.progress();
        double value = getReturnValue(toExecute);
        Constant toAdd = new Constant((int)value);
        getModel().getMap().put(variable, toAdd);
        getModel().getController().sendVariable(variable, (int)value);
        return value;
    }
}
