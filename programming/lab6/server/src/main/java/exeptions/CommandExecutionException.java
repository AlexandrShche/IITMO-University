package exeptions;

public class CommandExecutionException extends RuntimeException{
    public CommandExecutionException(){
        super("An error occurred during execution");
    }
}
