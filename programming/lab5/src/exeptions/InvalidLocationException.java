package exeptions;

public class InvalidLocationException extends InvalidWorkerFieldException{
    public InvalidLocationException(){
        super("Invalid location has been entered.");
    }
}
