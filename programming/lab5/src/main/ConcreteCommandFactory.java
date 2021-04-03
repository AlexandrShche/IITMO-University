package main;

import command.Command;
import exeptions.CommandExecutionException;
import exeptions.UnknownCommandException;

import java.util.Map;

public class ConcreteCommandFactory implements CommandFactory {

    private final Map<String,Command> commands;
    private final Messages messages;

    public ConcreteCommandFactory(Map<String, Command> commands, Messages messages) {
        this.commands = commands;
        this.messages = messages;
    }

    @Override
    public void executeCommand(String commandName, CommandAndOutputManager commandAndOutputManager,
                               String args, CollectionOfWorkerManager collectionOfWorkerManager) {
        Command command;
        try{
            command = getCommand(commandName);
        } catch (Exception e) {
            throw new UnknownCommandException();
        }
        try {
            command.execute(messages, commandAndOutputManager, args, collectionOfWorkerManager);
        } catch (Exception e){
            if(e.getMessage() != null){
                commandAndOutputManager.output(e.getMessage());
            }
            else{
                Exception e1 = new CommandExecutionException();
                commandAndOutputManager.output(e1.getMessage());
            }
        }
    }

    private Command getCommand(String commandName){
        return commands.get(commandName);
    }

}
