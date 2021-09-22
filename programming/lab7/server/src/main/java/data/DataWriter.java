package data;

import auth.Auth;
import exceptions.DBException;
import worker.Worker;

public interface DataWriter {
    void addElement(Worker worker, Auth auth) throws DBException;

    void updateElement(Worker worker, long id, Auth auth);

    void clearElements(Auth auth);

    void removeElement(long id, Auth auth);

    void addUser(Auth auth);
}
