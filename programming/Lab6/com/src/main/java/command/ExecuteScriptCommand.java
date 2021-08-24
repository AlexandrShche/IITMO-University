package command;

import command_execution.ScriptReader;
import worker.CollectionOfWorkersManager;

import java.io.Serializable;

public class ExecuteScriptCommand implements SimpleCommandWithArg, Serializable {
    private String ScriptName;
    private ScriptReader scriptReader;
    @Override
    public void setSimpleArg(String s) {
        ScriptName = s;
    }

    @Override
    public void execute() {
    }

    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
        collectionOfWorkersManager.saveBeforeDangerActions();
        try{

        } catch (Exception e){
            collectionOfWorkersManager.recover();
        }
    }

    @Override
    public String getResult() {
        return null;
    }
}
