package command;

import user.Auth;
import worker.CollectionOfWorkersManager;

import java.io.IOException;
import java.io.Serializable;

public class RegistrationCommand extends UsersCommand implements Serializable {
    private String login;
    private String password;

    public RegistrationCommand(String login, String password){
        this.login = login;
        this.password = password;
    }

    public RegistrationCommand(){

    }

    public String getLogin() {
        return login;
    }

    public String getPassword(){
        return password;
    }


    @Override
    public void setSimpleArg(String s) {

    }

    @Override
    public SimpleCommandWithArg clone() {
        return null;
    }

    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager, Auth auth) throws IOException {

    }
}
