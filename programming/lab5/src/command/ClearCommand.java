package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;

public class ClearCommand implements Command{
    public ClearCommand () {

    }
    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        CollectionOfWorkerManager collectionOfWorkerManager) {
        collectionOfWorkerManager.clear();
        commandAndOutputManager.output(messages.getClearDoneMessage());
    }
}
