package main;

import main.worker.Organization;
import main.worker.Worker;

import java.io.IOException;

public interface CommandAndOutputManager {
    void readCommands();
    void output(String string);
    Worker readWorker() throws IOException;
    void exit();
    Organization readOrganization();

    void output(Worker w);
}
