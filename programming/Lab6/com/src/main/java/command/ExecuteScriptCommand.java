package command.command;

public class ExecuteScriptCommand extends SimpleCommandWithArg {
    private String ScriptName;
    @Override
    public void execute() {

    }
    @Override
    public void setArg(String s){
        ScriptName = s;
    }
}
