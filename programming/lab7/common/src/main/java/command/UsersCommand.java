package command;

import worker.CollectionOfWorkersManager;

import java.io.IOException;
import java.io.Serializable;

public abstract class UsersCommand implements SimpleCommandWithArg, Serializable {
    protected String result;
    protected String login;
    protected String password;
    protected boolean success;

    @Override
    public String getResult() {
        return "result";
    }

    @Override
    public void setSimpleArg(String s) {
        String[] strings = s.split("\\s+");
        setLogin(strings[0]);
        setPassword(strings[1]);
    }

    @Override
    public SimpleCommandWithArg clone() {
        return null;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    protected void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }

    public String getLogin(){
        return login;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public boolean isSuccess(){
        return success;
    }
}
