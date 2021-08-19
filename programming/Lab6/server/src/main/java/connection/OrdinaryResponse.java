package network;

public class OrdinaryResponse implements Response{
    String message;
    boolean success;

    public OrdinaryResponse(String message, boolean success){
        this.message = message;
        this.success = success;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean getSuccess() {
        return success;
    }
}
