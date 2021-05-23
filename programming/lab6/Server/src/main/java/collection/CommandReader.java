package main;

import main.worker.Organization;
import main.worker.Worker;

import java.io.IOException;

public interface CommandReader{
    void readCommands() throws IOException;
    void exit();
    Worker readWorker() throws IOException;
    Organization readOrganization();
}
