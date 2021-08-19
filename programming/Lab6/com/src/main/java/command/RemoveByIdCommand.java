package command;

import worker.CollectionOfWorkersManager;

import java.io.Serializable;

public class RemoveByIdCommand implements Serializable, SimpleCommandWithArg {
    private long id;
    String result;
    @Override
    public void execute() {

    }

    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
        collectionOfWorkersManager.removeById(id);
        result = "the item was deleted";
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public void setSimpleArg(String s) {
        id = Long.parseLong(s);
    }
}