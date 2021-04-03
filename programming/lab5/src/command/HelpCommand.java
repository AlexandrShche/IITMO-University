package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;

import java.io.IOException;

public class HelpCommand implements Command {
    public HelpCommand(){
    }

    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        CollectionOfWorkerManager collectionOfWorkerManager) throws IOException {
        commandAndOutputManager.output(messages.getCommands());
    }
}

