package data;

import auth.Auth;
import exceptions.DBException;
import worker.Worker;

import java.util.Collection;
import java.util.Set;

public interface DataReader {
    Collection<Worker> readElements() throws DBException;
    Worker getElement(long id) throws DBException;
    Set<Auth> readUsers() throws DBException;
    Worker getLastElement() throws DBException;
}
