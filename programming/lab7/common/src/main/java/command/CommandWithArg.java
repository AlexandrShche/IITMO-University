package command;

import user.Auth;
import worker.CollectionOfWorkersManager;

public interface CommandWithArg extends Command{

    @Override
    default String getResult() {
        return null;
    }
}
