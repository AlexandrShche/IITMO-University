package data;

import user.Auth;
import exceptions.DBException;
import worker.Worker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class DBWriter implements DataWriter {
    private final Connection connection;

    public DBWriter(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addElement(Worker worker, Auth auth) throws DBException {
        try (PreparedStatement stm = connection.prepareStatement(
                "insert into workers (id, name, coordinate_x, coordinate_y, salary, position, status," +
                        " creation_date, end_date, organization_name, author) values " +
                        "(nextval('workers_id_seq'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")){
            setWorkerToStatement(worker, stm);
            stm.setString(10, auth.getLogin());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    @Override
    public void updateElement(Worker worker, long id, Auth auth) {

    }

    @Override
    public void clearElements(Auth auth) {

    }

    @Override
    public void removeElement(long id, Auth auth) {

    }

    @Override
    public void addUser(Auth auth) {

    }

    private void setWorkerToStatement(Worker worker, PreparedStatement stm) throws SQLException {
        stm.setString(1, worker.getName());
        stm.setDouble(2, worker.getCoordinates().getX());
        stm.setFloat(3, worker.getCoordinates().getY());
        stm.setDouble(4, worker.getSalary());
        stm.setString(5, String.valueOf(worker.getPosition()));
        stm.setString(6, String.valueOf(worker.getStatus()));
        stm.setDate(7, Date.valueOf(worker.getCreationDate().toLocalDate()));
        if(worker.getEndDate()==null){
            stm.setDate(8, null);
        } else {
            stm.setDate(8, Date.valueOf(String.valueOf(ZonedDateTime.from(worker.getEndDate()))));
        }
        if(worker.getOrganization() == null) {
            stm.setString(9, null);
        } else {
            stm.setString(9, worker.getOrganization().getFullName());
        }
    }
}
