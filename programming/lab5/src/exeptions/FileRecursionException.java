package exeptions;

public class FileRecursionException extends RuntimeException{
    public FileRecursionException() {
        super("Error. File recursion detected.");
    }
}
