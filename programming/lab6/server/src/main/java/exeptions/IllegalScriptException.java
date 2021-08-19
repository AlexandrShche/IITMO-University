package exeptions;

public class IllegalScriptException extends RuntimeException {
    public IllegalScriptException() {
        super("Errors with script");
    }
}