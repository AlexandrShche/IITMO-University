package command.command;

import worker.Worker;

public abstract class CommandWithWorkerArg implements CommandWithArg{
    protected Worker worker;
    public void setArg(Worker worker) {
        this.worker = worker;
    }
}
