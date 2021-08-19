package command;

import worker.CollectionOfWorkersManager;
import worker.Worker;

import java.io.Serializable;

public class UpdateCommand extends CommandWithWorkerArg implements SimpleCommandWithArg, Serializable {
    long id;
    String result;
    @Override
    public void setSimpleArg(String s) {
        id = Long.parseLong(s);
    }

    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
        collectionOfWorkersManager.updateWorkerById(id, worker);
        result = "Worker has been updated";
    }

    @Override
    public String getResult() {
        return result;
    }
}
