package exeptions;

public class InvalidOrganizationException extends InvalidWorkerFieldException{
    public InvalidOrganizationException(){
        super("Invalid organization has been entered.");
    }
}
