package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;

import java.io.IOException;

public class ExitCommand implements Command{
    public ExitCommand(){

    }

    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        CollectionOfWorkerManager collectionOfWorkerManager) throws IOException {
        commandAndOutputManager.exit();
    }
}
