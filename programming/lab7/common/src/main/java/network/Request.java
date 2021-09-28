package network;

import command.Command;
import command.CommandWithArg;
import command.CommandWithOrganizationArg;
import command.CommandWithWorkerArg;
import user.Auth;
import worker.OrdinaryWorker;
import worker.Organization;
import worker.Worker;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 111113171L;
    private final Command command;
    private Worker worker;
    private Organization organization;
    private final Auth auth;

    public Request(Command command, Auth auth){
        this.command = command;
        this.auth = auth;
        if(command instanceof CommandWithArg){
            if(command instanceof CommandWithOrganizationArg){
                organization = ((CommandWithOrganizationArg) command).getOrganization();
            }
            if(command instanceof CommandWithWorkerArg){
                worker = ((CommandWithWorkerArg) command).getWorker();
            }
        }
    }



    public Command getCommand() {
        return this.command;
    }

    @Override
    public String toString(){
        return command.toString();
    }

    public Auth getAuth() {
        return auth;
    }
}
