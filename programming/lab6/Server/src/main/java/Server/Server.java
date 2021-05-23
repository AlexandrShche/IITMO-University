package main.java.Server;

import main.CollectionOfWorkerManager;
import main.CommandFactory;
import main.CommandReader;
import main.ConcreteCommandFactory;
import main.JSONFileWorkerWriter;
import main.ListOfWorkerManager;
import exeptions.IncorrectFileSettings;

public class Server {
    public static String dataFileName;
    public static void main(String[] args){
        System.out.println("Server was started");
        dataFileName = System.getenv("DATA_FOR_LAB6");
        if(dataFileName == null){
            throw new IncorrectFileSettings();
        }
        CommandFactory commandFactory = new ConcreteCommandFactory(commands, messages);
        CollectionOfWorkerManager collectionOfWorkerManager =
                new ListOfWorkerManager(new main.JSONFileWorkerReader(dataFileName),
                        new JSONFileWorkerWriter(dataFileName));
        CommandReader commandReader = new ServerCommandReader();
        collectionOfWorkerManager.parseDataToCollection();
        commandReader.readCommands();
    }
}
