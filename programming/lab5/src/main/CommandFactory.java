package main;

public interface CommandFactory {
    void executeCommand(String command, CommandAndOutputManager commandAndOutputManager,
                        String args, CollectionOfWorkerManager collectionOfWorkerManager);
}
