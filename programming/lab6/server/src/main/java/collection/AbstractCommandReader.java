package main;

import exeptions.IllegalScriptException;
import exeptions.UnknownCommandException;

import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;

public abstract class AbstractCommandReader implements CommandReader{
    protected CollectionOfWorkerManager collectionOfWorkerManager;
    protected BufferedReader reader;
    protected CommandFactory commandFactory;
    protected Messages messages;
    protected boolean isRunning;
    protected Messenger messenger;

    public AbstractCommandReader(CollectionOfWorkerManager collectionOfWorkerManager, Messages messages, Messenger messenger, CommandFactory commandFactory){
        this.messenger = messenger;
        this.messages = messages;
        this.collectionOfWorkerManager = collectionOfWorkerManager;
        this.commandFactory = commandFactory;
    }

    public void decodeAndTryExecuteCommand(String[] command) {
            try {
                if (command.length == 1) {
                    commandFactory.executeCommand(command[0], this, null, collectionOfWorkerManager);
                }
                else if (command.length == 2){
                    commandFactory.executeCommand(command[0], this, command[1], collectionOfWorkerManager);
                }
                else{
                    throw new UnknownCommandException();
                }
            }catch (IllegalScriptException e){
                messenger.output(e.getMessage());
            } catch (UnknownCommandException e){
                messenger.output(messages.getTryAgainMessage());
            }
    }
}
