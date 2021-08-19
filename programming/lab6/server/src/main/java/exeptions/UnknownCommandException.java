package exeptions;

public class UnknownCommandException extends RuntimeException{
    public UnknownCommandException() {
        super("Error. Unknown command has been entered.");
    }
}
