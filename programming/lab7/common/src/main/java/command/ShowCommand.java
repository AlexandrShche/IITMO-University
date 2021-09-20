package command;

import worker.CollectionOfWorkersManager;
import java.io.Serializable;

public class ShowCommand extends SimpleCommand implements Serializable {
    private String result;
    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
        StringBuilder stringBuilder = new StringBuilder();
        if (collectionOfWorkersManager.getSize() == 0) {
            result = "Collection is empty";
        } else {
            for (int i = 0; i < collectionOfWorkersManager.getSize(); ++i) {
                stringBuilder.append(collectionOfWorkersManager.getWorkerByNumber(i).toFormalString());
            }
            result = stringBuilder.toString();
        }
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof ShowCommand){
            return true;
        }
        return false;
    }
}