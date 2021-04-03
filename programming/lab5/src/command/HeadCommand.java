package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;

import java.io.IOException;

public class HeadCommand implements Command{
    public HeadCommand(){

    }

    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        CollectionOfWorkerManager collectionOfWorkerManager) throws IOException {
        collectionOfWorkerManager.getHead();
    }
}
