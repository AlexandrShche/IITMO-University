package command;

import exceptions.NoSuchWorkerException;
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
        if(collectionOfWorkersManager.collectionIsEmpty()) {
            result = "collection is empty";
        } else {
            try {
                collectionOfWorkersManager.updateWorkerById(id, worker);
                result = "Worker has been updated";
            } catch (NoSuchWorkerException nswe){
                result = "Worker was not found";
            }
        }
    }

    @Override
    public String getResult() {
        return result;
    }


}
