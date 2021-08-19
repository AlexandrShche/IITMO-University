package command_execution;

import worker.CollectionOfWorkersManager;
import command.Command;
import command.ExecuteScriptCommand;
import exceptions.CommandExecuteException;

import java.io.IOException;

public class CommandExecutorImpl implements CommandExecutor {
    CollectionOfWorkersManager collectionOfWorkersManager;

    public CommandExecutorImpl(CollectionOfWorkersManager collectionOfWorkersManager) {
        this.collectionOfWorkersManager = collectionOfWorkersManager;
    }

    @Override
    public String executeCommand(Command command) {
        try {
            if (command instanceof ExecuteScriptCommand) {
                command.execute();
            }
                command.execute(collectionOfWorkersManager);
            log.Logback.getLogger().info(command.toString() + " was executed");
            String result = command.getResult();

            return result;

        } catch (CommandExecuteException | IOException cee){
            return "не получилось, не фартануло";
        }
    }
}
