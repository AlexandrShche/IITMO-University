package main;

import main.worker.Worker;

public interface Messenger {
    void output(String string);
    void output(Worker worker);
}
