package server;
import application.Application;
import worker.CollectionOfWorkersManager;
import collection.JSONFileWorkerReader;
import collection.JSONFileWorkerWriter;
import collection.ListOfWorkerManager;
import command.Command;
import command_execution.CommandExecutor;
import command_execution.CommandExecutorImpl;
import connection.*;
import exceptions.CommandExecuteException;
import exceptions.CommandExecutionException;
import exceptions.IncorrectFileSettings;
import network.Request;
import network.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.Selector;
import java.util.Locale;

public class ServerApplication implements Application{
    public static String dataFileName = System.getenv("DATA_FOR_LAB6");
    boolean isRunning;
    private RequestReader requestReader = new RequestReaderImpl();
    private ResponseWriter responseWriter = new ResponseWriterImpl();
    private ServerConnectionManager serverConnectionManager = new ServerConnectionManagerImpl();
    private CollectionOfWorkersManager collectionOfWorkersManager = new
                                        ListOfWorkerManager(new JSONFileWorkerReader(dataFileName),
                                                            new JSONFileWorkerWriter(dataFileName));
    private CommandExecutor commandExecutor = new CommandExecutorImpl(collectionOfWorkersManager);
    private ResponseSender responseSender = new ResponseSenderImpl();


    String address = "localhost";
    int port = 8888;

    public void start(){
        consoleStart();
        log.Logback.getLogger().info("server was started");
        isRunning = true;
        Command command;
        if(dataFileName == null){
            throw new IncorrectFileSettings();
        }
        try{
            collectionOfWorkersManager.parseDataToCollection();
            log.Logback.getLogger().info("data was parsed");
        } catch (Exception e){

            log.Logback.getLogger().error("Problems with data file");
            e.printStackTrace();
        }
        Selector selector;
        while(isRunning){
            try {
                serverConnectionManager.openConnection(address, port);
                log.Logback.getLogger().info("connection is open");
                try {
                    selector = serverConnectionManager.listen();
                } catch (ClosedSelectorException e){
                    log.Logback.getLogger().warn("close selector exception");
                    return;
                }
                try {
                    Request request = requestReader.readRequest(selector);
                    log.Logback.getLogger().info("Request was received");
                    command = request.getCommand();
                    log.Logback.getLogger().info("Command was decrypted");
                    String result;
                    try {
                        result = commandExecutor.executeCommand(command);
                    } catch (Exception e){
                        e.printStackTrace();
                        log.Logback.getLogger().error("Error with command execution");
                        result = "error :(";
                    }
                    log.Logback.getLogger().info("Command was executed");
                    Response response = responseWriter.writeResponse(result);
                    log.Logback.getLogger().info("Response was wrote");
                    responseSender.sendResponse(response, selector);
                    log.Logback.getLogger().info("Response was sent");
                    serverConnectionManager.stop();
                    log.Logback.getLogger().info("Client was served");
                } catch (CommandExecuteException | CommandExecutionException e){
                    log.Logback.getLogger().warn("Command execute exception");
                    Response response = new Response(e.getMessage(), false);
                    log.Logback.getLogger().info("Response with error massage was wrote");
                    responseSender.sendResponse(response, selector);
                    log.Logback.getLogger().info("Response was sent");
                    serverConnectionManager.stop();
                    log.Logback.getLogger().info("Client was served");
                } finally {

                }
            } catch (IOException ioe){

                ioe.printStackTrace();
                try{
                    serverConnectionManager.stop();
                } catch (Exception e){
                    isRunning = false;
                }
            } catch (Exception e){
                e.printStackTrace();
                return;
            }
        }
    }

    private void consoleStart(){
        Thread consoleTread = new Thread(() -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(!Thread.interrupted()){
                try{
                    String str = reader.readLine().trim().toLowerCase(Locale.ROOT);
                    if(str.equals("save")){
                        collectionOfWorkersManager.save();
                        log.Logback.getLogger().warn("Collection was saved");
                    } else {
                        if(str.equals("exit")){
                            this.exit();
                        }
                        else {
                        log.Logback.getLogger().warn("Incorrect server command has been input");
                        System.out.println("чё?");}
                    }
                } catch (IOException ioe){
                    log.Logback.getLogger().error("ioe");
                }
            }
        });
        consoleTread.setDaemon(true);
        consoleTread.start();
    }

    public void exit() throws IOException {
        collectionOfWorkersManager.save();
        log.Logback.getLogger().warn("Collection was saved");
        serverConnectionManager.stop();
        isRunning = false;
    }
}
