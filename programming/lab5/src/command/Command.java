package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;

import java.io.IOException;

public interface Command {
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        String arg, CollectionOfWorkerManager collectionOfWorkerManager) throws IOException;
}
