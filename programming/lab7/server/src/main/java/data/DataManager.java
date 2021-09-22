package data;

import auth.Auth;
import exceptions.DBException;
import worker.Worker;

import java.util.Collection;
import java.util.Set;

public interface DataManager {
    Collection<Worker> readCollection() throws DBException;
    Worker addElement(Worker worker, Auth auth) throws DBException;

    Worker updateElement(Worker worker, long id, Auth auth) throws DBException;

    void clearElements(Auth auth);

    void removeElement(long id, Auth auth);

    void addUser(Auth auth);

    Set<Auth> readUsers() throws DBException;
}
