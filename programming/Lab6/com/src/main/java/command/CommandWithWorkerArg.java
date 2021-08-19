package command;

import worker.OrdinaryWorker;
import worker.Worker;

import java.io.Serializable;

public abstract class CommandWithWorkerArg implements CommandWithArg, Serializable {
    protected Worker worker;
    public void setArg(OrdinaryWorker worker) {
        this.worker = worker;
    }
    public OrdinaryWorker getWorker(){
        return (OrdinaryWorker) worker;
    }
}
