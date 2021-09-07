package command;

import worker.CollectionOfWorkersManager;
import worker.OrdinaryWorker;
import worker.Worker;

import java.io.IOException;

public interface Command{
    default void execute() throws IOException {}
    void execute(CollectionOfWorkersManager collectionOfWorkersManager) throws IOException;
    String getResult();
}
