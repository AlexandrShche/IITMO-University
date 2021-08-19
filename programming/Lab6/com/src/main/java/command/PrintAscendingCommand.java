package command;

import worker.CollectionOfWorkersManager;
import worker.Worker;

import java.io.Serializable;
import java.util.LinkedList;

public class PrintAscendingCommand extends SimpleCommand implements Serializable {
    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ascending list of workers:\n");
        LinkedList<Worker> workers = collectionOfWorkersManager.getAscending();
        for (Worker w:workers) {
            stringBuilder.append(w.toFormalString());
        }
    }

    @Override
    public String getResult() {
        return null;
    }
}
