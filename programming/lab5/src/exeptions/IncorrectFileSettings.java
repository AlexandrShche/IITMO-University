package exeptions;

public class IncorrectFileSettings extends RuntimeException{
    public IncorrectFileSettings(){
        super("Incorrect file settings.");
    }
}
