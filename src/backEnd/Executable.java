package backEnd;

/**
 * To implement this interface you must have the execute method. 
 * Hence you are "executable". 
 * @author Francesco Agosti
 *
 */
public interface Executable {
    
    /**
     * Basic method of Executables
     * @param toExecute Instruction to act on
     * @return returns the value the function returns
     */
    public double execute(Instruction toExecute);
}
