package command;

import main.CollectionOfWorkerManager;
import main.CommandAndOutputManager;
import main.Messages;
import main.worker.Worker;

import java.io.IOException;
import java.util.Arrays;

public class PrintFieldDescendingSalaryCommand implements Command{
    public PrintFieldDescendingSalaryCommand(){

    }

    @Override
    public void execute(Messages messages, CommandAndOutputManager commandAndOutputManager,
                        CollectionOfWorkerManager collectionOfWorkerManager) throws IOException {
        Double[] array = collectionOfWorkerManager.getFieldDescendingSalary();
        Arrays.sort(array);
        for(Double d:array){
            System.out.println(d);
        }
    }
}
