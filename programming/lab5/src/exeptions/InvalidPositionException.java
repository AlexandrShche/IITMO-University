package exeptions;

public class InvalidPositionException extends InvalidWorkerFieldException{
    public InvalidPositionException(){
        super("Invalid position has been entered.");
    }
}
