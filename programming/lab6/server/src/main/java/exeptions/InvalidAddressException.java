package exeptions;

public class InvalidAddressException extends InvalidWorkerFieldException{
    public InvalidAddressException(){
        super("Invalid address has been entered.");
    }
}
