package exeptions;

public class InvalidCoordinatesException extends InvalidWorkerFieldException{
    public InvalidCoordinatesException() {
        super("No coordinates have been entered.");
    }
}
