package server;

import application.Application;
import auth.AuthManager;
import auth.AuthManagerImpl;
import command.*;
import command_execution.CommandExecutor;
import command_execution.CommandExecutorImpl;
import command_execution.ScriptReaderImpl;
import connection.*;
import data.DBManager;
import data.DataManager;
import exceptions.CommandExecuteException;
import exceptions.CommandExecutionException;
import network.Request;
import network.Response;
import server_commands.ExecuteScriptCommand;
import server_commands.ExitCommand;
import user.Auth;
import worker.CollectionOfWorkersManager;
import data.ListOfWorkerManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class ServerApplication implements Application{
    boolean isRunning;
    private final RequestReader requestReader = new RequestReaderImpl();
    private final ResponseWriter responseWriter = new ResponseWriterImpl();
    private final ServerConnectionManager serverConnectionManager = new ServerConnectionManagerImpl();
    private final AuthManager authManager = new AuthManagerImpl();
    private DataManager dataManager;
    private CollectionOfWorkersManager collectionOfWorkersManager;
    private CommandExecutor commandExecutor;
    private final ResponseSender responseSender = new ResponseSenderImpl();
    private Map<String, Command> serverCommands;

    String address = "localhost";
    int port = 8888;

    public void start(){
        try {
            serverCommands = getServerCommand();
        } catch (IOException ioe){
            log.Logback.getLogger().error("problems with script command");
        }
        consoleStart();
        log.Logback.getLogger().info("server was started");
        isRunning = true;
        Command command;

        try{
            FileInputStream fis = new FileInputStream("/home/alexander/HomeWorks/programming/lab7/server/src/main/resources/config.properties");
            Properties properties = new Properties();
            properties.load(fis);
            String url = (String) properties.get ("db.url");
            String username = (String) properties.get ("db.username");
            String password = (String) properties.get ("db.password");

            dataManager = new DBManager(url, username, password);
            authManager.setUsers(dataManager.readUsers());
            collectionOfWorkersManager = new ListOfWorkerManager(dataManager);
            commandExecutor = new CommandExecutorImpl(collectionOfWorkersManager, authManager);
            log.Logback.getLogger().info("data was parsed");
        } catch (Throwable e){
            log.Logback.getLogger().error("Problems with DB");
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
                    String user;
                    if(request.getAuth() != null) {
                        user = request.getAuth().getLogin();
                    } else {
                        user = "null user";
                    }
                    log.Logback.getLogger().info("Request was received from " + user);


                    command = request.getCommand();
                    log.Logback.getLogger().info("Command was decrypted");
                    System.out.println(command.toString());
                    String result;
                    try {
                        result = commandExecutor.executeCommand(command, request.getAuth());
                    } catch (Exception e){
                        e.printStackTrace();
                        log.Logback.getLogger().error("Error with command execution");
                        result = "error :(";
                    }
                    log.Logback.getLogger().info("Command was executed");
                    Response response;
                    if(command instanceof UsersCommand){
                        response = responseWriter.writeResponse(result, ((UsersCommand) command).isSuccess());
                    } else {
                        response = responseWriter.writeResponse(result);
                    }
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
                    String[] str = reader.readLine().trim().split("\\s+");
                    Command command = serverCommands.get(str[0].toLowerCase(Locale.ROOT));
                    if(command != null){
                        if(command instanceof ExecuteScriptCommand){
                            ((ExecuteScriptCommand) command).execute(collectionOfWorkersManager, str[1]);
                        } else {
                            Auth auth = new Auth("server", "Fk4Dl3igjeriehioefjlajie" );
                            command.execute(collectionOfWorkersManager, null);
                        }
                    } else {
                        log.Logback.getLogger().error("unknowing command");
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
        log.Logback.getLogger().warn("Collection was saved");
        serverConnectionManager.stop();
        isRunning = false;
    }

    private Map<String, Command> getServerCommand() throws IOException {
        Map<String, Command> result = new HashMap<>();
        result.put("exit", new ExitCommand(this));
        result.put("execute_script", new ExecuteScriptCommand(new ScriptReaderImpl(getScriptCommands())));
        return result;
    }

    private Map<String, Command> getScriptCommands() {
        Map<String, Command> result = new HashMap<>();
        result.put("add", new AddCommand());
        result.put("add_if_min", new AddIfMinCommand());
        result.put("clear", new ClearCommand());
        result.put("remove_by_id", new RemoveByIdCommand());
        result.put("remove_head", new RemoveHeadCommand());
        result.put("update", new UpdateCommand());
        return result;
    }
}
