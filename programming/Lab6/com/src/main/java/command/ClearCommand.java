package command;

import worker.CollectionOfWorkersManager;

import java.io.Serializable;

public class ClearCommand extends SimpleCommand implements Serializable {
    String result;

    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
        collectionOfWorkersManager.clear();
        result = "Collection was cleared";
    }

    @Override
    public String getResult() {
        return result;
    }
}
