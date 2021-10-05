package command;

import user.Auth;
import worker.CollectionOfWorkersManager;
import worker.OrdinaryWorker;
import worker.Worker;

import java.io.Serializable;

public abstract class CommandWithWorkerArg implements CommandWithArg, Serializable, Cloneable {
    protected OrdinaryWorker worker;
    protected boolean success;
    public void setArg(OrdinaryWorker worker) {
        this.worker = worker;
    }
    public OrdinaryWorker getWorker(){
        return worker;
    }

    @Override
    public String toString(){
        return "";
       // return "commandWithWorkerArg" + worker.toFormalString();
    }


    @Override
    public CommandWithWorkerArg clone() {
        try {
            CommandWithWorkerArg clone = (CommandWithWorkerArg) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
