package command;

import worker.CollectionOfWorkersManager;

import java.io.Serializable;

public class ExecuteScriptCommand implements SimpleCommandWithArg, Serializable {
    private String ScriptName;
    @Override
    public void setSimpleArg(String s) {
        ScriptName = s;
    }

    @Override
    public void execute() {

    }

    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {

    }

    @Override
    public String getResult() {
        return null;
    }
}
