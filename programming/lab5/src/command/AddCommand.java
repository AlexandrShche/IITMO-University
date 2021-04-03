package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;

import java.io.IOException;

public class AddCommand implements Command{
    public AddCommand(){

    }

    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        CollectionOfWorkerManager collectionOfWorkerManager) throws IOException {
        collectionOfWorkerManager.addWorker(commandAndOutputManager.readWorker());
    }
}
