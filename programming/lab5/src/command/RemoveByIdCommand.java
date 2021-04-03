package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;

import java.io.IOException;

public class RemoveByIdCommand implements Command{
    public RemoveByIdCommand(){

    }

    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        String arg, CollectionOfWorkerManager collectionOfWorkerManager) throws IOException {
        Long id = Long.parseLong(arg);
        collectionOfWorkerManager.removeById(id);
    }
}
