package command;

import worker.CollectionOfWorkersManager;
import worker.Worker;

import java.io.Serializable;

public class RemoveHeadCommand extends SimpleCommand implements Serializable {
    String result;
    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
         Worker w = collectionOfWorkersManager.removeHead();
         result = w.toFormalString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
