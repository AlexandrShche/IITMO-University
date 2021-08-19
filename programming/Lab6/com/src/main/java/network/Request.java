package network;

import command.Command;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 111113171L;
    Command command;

    public Request(Command command){
        this.command = command;
    }

    public Command getCommand() {
        return this.command;
    }
}
