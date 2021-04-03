package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;
import main.worker.Worker;

import java.io.IOException;
import java.util.LinkedList;

public class PrintAscendingCommand implements Command{
    public PrintAscendingCommand(){

    }

    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        CollectionOfWorkerManager collectionOfWorkerManager) throws IOException {
        LinkedList<Worker> workers = collectionOfWorkerManager.getAscending();
        for(Worker w:workers){
            commandAndOutputManager.output(w);
        }
    }
}
