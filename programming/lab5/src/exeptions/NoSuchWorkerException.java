package exeptions;

import java.util.NoSuchElementException;

public class NoSuchWorkerException extends NoSuchElementException {
    public NoSuchWorkerException(){
        super("There is no such worker on the list or list is empty");
    }
}
