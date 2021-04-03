package command;

import exeptions.CommandExecutionException;
import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;
import main.worker.Worker;

public class AddIfMinCommand implements Command{
    public AddIfMinCommand(){

    }
    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        CollectionOfWorkerManager collectionOfWorkerManager){
        Worker worker;
        try{
            collectionOfWorkerManager.addIfMin(commandAndOutputManager.readWorker());
        } catch (Exception e){
            throw new CommandExecutionException();
        }

    }
}
