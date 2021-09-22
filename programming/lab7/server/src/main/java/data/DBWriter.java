package data;

import auth.Auth;
import exceptions.DBException;
import worker.Worker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class DBWriter implements DataWriter {
    private final Connection connection;

    public DBWriter(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addElement(Worker worker, Auth auth) throws DBException {
        try (PreparedStatement stm = connection.prepareStatement(
                "insert into persons (id, name, coordinates_x, coordinates_y, height, birthday, eyecolor, " +
                        "haircolor, location_x, location_y, location_name, creationdate, owner) values " +
                        "(nextval('id_seq'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")){
            setPersonToStatement(worker, stm);
            stm.setDate(11, Date.valueOf(LocalDate.now()));
            stm.setString(12, auth.getLogin());
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

    private void setPersonToStatement(Worker worker, PreparedStatement stm) throws SQLException {
        stm.setString(1, worker.getName());
        stm.setDouble(2, worker.getCoordinates().getX());
        stm.setFloat(3, worker.getCoordinates().getY());
        stm.setDouble(4, worker.getSalary());
        stm.setString(5, String.valueOf(worker.getPosition()));
        stm.setString(6, String.valueOf(worker.getStatus()));
        stm.setDate(7, Date.valueOf(worker.getCreationDate().toLocalDate()));
        stm.setDate(8, Date.valueOf(String.valueOf(ZonedDateTime.from(worker.getEndDate()))));
        stm.setString(9, worker.getOrganization().getFullName());
    }
}
