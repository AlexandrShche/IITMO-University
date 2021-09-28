package command_execution;

import auth.AuthManager;
import command.AuthorizationCommand;
import command.RegistrationCommand;
import command.UsersCommand;
import data.DataManager;
import user.Auth;
import worker.CollectionOfWorkersManager;
import command.Command;
import server_commands.ExecuteScriptCommand;
import exceptions.CommandExecuteException;

import java.io.IOException;

public class CommandExecutorImpl implements CommandExecutor {
    private final CollectionOfWorkersManager collectionOfWorkersManager;
    private final AuthManager authManager;

    public CommandExecutorImpl(CollectionOfWorkersManager collectionOfWorkersManager, AuthManager authManager) {
        this.collectionOfWorkersManager = collectionOfWorkersManager;
        this.authManager = authManager;
    }

    @Override
    public String executeCommand(Command command, Auth auth) {
        String result = "";
        try {
            if (command instanceof ExecuteScriptCommand) {
                command.execute();
            }
            if (command instanceof UsersCommand){
                String login = ((UsersCommand) command).getLogin();
                String password = ((UsersCommand) command).getPassword();
                Auth newAuth = new Auth(login, password);
                if(command instanceof AuthorizationCommand){
                    if(authManager.checkAuth(newAuth)){
                        authManager.addOnlineUser(newAuth);
                        result = "You are authorized!";
                        ((AuthorizationCommand) command).setSuccess(true);
                    } else {
                        result = "Error authorization";
                    }
                }
                if(command instanceof RegistrationCommand){
                    if(authManager.checkAuth(newAuth)){
                        result = "Вы уже зарегистрированы";
                    } else {
                        authManager.addUser(newAuth);
                        result = "Успешная регистрация! Осталось лишь войти)";
                    }
                }
            }
            else {
                command.execute(collectionOfWorkersManager, auth);

                log.Logback.getLogger().info(command.toString() + " was executed");
                result = command.getResult();

            }
            log.Logback.getLogger().info("result: " + result);
            return result;
        } catch (CommandExecuteException | IOException cee){
            return "не получилось, не фартануло";
        }
    }
}
