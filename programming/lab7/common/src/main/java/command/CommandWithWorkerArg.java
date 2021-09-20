package command;

import worker.OrdinaryWorker;
import worker.Worker;

import java.io.Serializable;

public abstract class CommandWithWorkerArg implements CommandWithArg, Serializable, Cloneable {
    protected OrdinaryWorker worker;
    public void setArg(OrdinaryWorker worker) {
        this.worker = worker;
    }
    public OrdinaryWorker getWorker(){
        return worker;
    }

    @Override
    public String toString(){
        return "commandWithWorkerArg" + worker.toFormalString();
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