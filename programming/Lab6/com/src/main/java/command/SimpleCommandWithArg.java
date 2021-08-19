package command.command;

public abstract class SimpleCommandWithArg implements Command {
    private String arg;
    public void setArg(String s){
        arg = s;
    }
}
