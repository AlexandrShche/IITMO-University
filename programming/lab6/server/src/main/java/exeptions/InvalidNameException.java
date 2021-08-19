package exeptions;

public class InvalidNameException extends InvalidWorkerFieldException{
    public InvalidNameException(){
        super("Invalid name has been entered.");
    }
}
