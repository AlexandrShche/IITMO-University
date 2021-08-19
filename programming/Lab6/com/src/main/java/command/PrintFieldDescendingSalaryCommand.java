package command;

import worker.CollectionOfWorkersManager;

import java.io.Serializable;

public class PrintFieldDescendingSalaryCommand extends SimpleCommand implements Serializable {
    String result;
    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
        Double[] doubles = collectionOfWorkersManager.getFieldDescendingSalary();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Salaries of employees in descending order:");
        for (Double d:doubles) {
            stringBuilder.append(d.toString());
        }
        result = stringBuilder.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
