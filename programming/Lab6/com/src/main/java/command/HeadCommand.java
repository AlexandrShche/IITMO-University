package command;

import worker.CollectionOfWorkersManager;
import worker.Worker;

import java.io.Serializable;

public class HeadCommand extends SimpleCommand implements Serializable {
    String result;
    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
        Worker worker = collectionOfWorkersManager.getHead();
        result = worker.toFormalString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
