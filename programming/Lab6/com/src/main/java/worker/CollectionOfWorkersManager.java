package worker;

import worker.Worker;
import worker.Organization;

import java.util.Collection;
import java.util.LinkedList;

public interface CollectionOfWorkersManager {
    Worker getWorkerByNumber(int number);
    void addWorker(Worker worker);
    String getInfo();
    void updateWorkerById(long id, Worker worker);
    void removeById(long id);
    void clear();
    void save();
    Worker getHead();
    Worker removeHead();
    void addIfMin(Worker worker);
    long countLessThanOrganization(Organization organization);
    LinkedList getAscending();
    Double[] getFieldDescendingSalary();
    void parseDataToCollection();
    int getSize();
    void saveBeforeDangerActions();
    void recover();
    Collection<Worker> getListOfWorkers();
}
