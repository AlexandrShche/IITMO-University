package command;

import worker.CollectionOfWorkersManager;
import worker.Worker;

import java.io.Serializable;

public class AddCommand extends CommandWithWorkerArg implements Serializable{
    private String result;

    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
        collectionOfWorkersManager.addWorker(worker);
        result = "worker was added";
    }

    @Override
    public String getResult() {
        return result;
    }
}
