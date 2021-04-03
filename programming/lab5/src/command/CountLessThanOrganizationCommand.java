package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;
import main.worker.Organization;

import java.io.IOException;

public class CountLessThanOrganizationCommand implements Command{
    public CountLessThanOrganizationCommand(){

    }

    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        CollectionOfWorkerManager collectionOfWorkerManager) throws IOException {
        collectionOfWorkerManager.countLessThanOrganization(commandAndOutputManager.readOrganization());
    }
}
