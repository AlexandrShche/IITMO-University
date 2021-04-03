package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;

public class InfoCommand implements Command{
    public InfoCommand (){

    }
    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        CollectionOfWorkerManager collectionOfWorkerManager) {
        commandAndOutputManager.output(collectionOfWorkerManager.getInfo());
    }
}
