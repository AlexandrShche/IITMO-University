package command;

import worker.CollectionOfWorkersManager;

import java.io.Serializable;

public class CountLessThanOrganizationCommand extends CommandWithOrganizationArg implements Serializable {
    String result;
    @Override
    public void execute(CollectionOfWorkersManager collectionOfWorkersManager) {
        long res = collectionOfWorkersManager.countLessThanOrganization(organization);
        result = String.valueOf(res);
    }

    public String getResult(){
        return result;
    }
}
