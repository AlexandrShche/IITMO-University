package exeptions;

public class InvalidStatusException extends InvalidWorkerFieldException{
    public InvalidStatusException(){
        super("Invalid status has been entered.");
    }
}
