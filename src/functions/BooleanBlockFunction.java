package functions;

import backEnd.Model;

public abstract class BooleanBlockFunction extends BlockFunction {

	public BooleanBlockFunction (Model model) {
		super(model);
	}
	
	@Override
	public String[] getOutput (String[] args) {
		return new String[0];
	}

}
