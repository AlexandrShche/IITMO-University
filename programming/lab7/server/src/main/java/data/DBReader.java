package data;

import auth.Auth;
import exceptions.DBException;
import exceptions.InvalidWorkerFieldException;
import org.slf4j.Logger;
import worker.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DBReader implements DataReader {
    private final Connection connection;
    
    public DBReader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Collection<Worker> readElements() throws DBException {
        Collection<Worker> persons = new TreeSet<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from persons");
            while(rs.next()){
                persons.add(createPerson(rs));
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return persons;
    }

    @Override
    public Set<Auth> readUsers() throws DBException {
        Set<Auth> users = new HashSet<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from users");
            while(rs.next()){
                users.add(new Auth(rs.getString("username"), rs.getString("password")));
            }
            return users;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    @Override
    public Worker getElement(long id) throws DBException {
        try (Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery("select * from workers where id = " + id);
            if (rs.next()) {
                return createPerson(rs);
            } else {
                throw new InvalidWorkerFieldException("id");
            }

        } catch (SQLException  e){
            throw new DBException(e);
        }
    }

    @Override
    public Worker getLastElement() throws DBException {
        try (Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery("select * from workers where id = (select max(id) from persons)");
            if (rs.next()) {
                return createPerson(rs);
            } else {
                return null;
            }
        } catch (SQLException  e){
            throw new DBException(e);
        }
    }

    private Worker createPerson(ResultSet rs) throws SQLException {
        Worker worker = new OrdinaryWorker();
        worker.setName(rs.getString("name"));
        Coordinates coordinates = new
                OrdinaryCoordinates(rs.getDouble("coordinate_x"), rs.getFloat("coordinate_y"));
        worker.setCoordinates(coordinates);
        worker.setSalary(rs.getDouble("salary"));
        worker.setPosition(Position.valueOf(rs.getString("position")));
        worker.setStatus(Status.valueOf(rs.getString("status")));
        worker.setCreationDate(rs.getDate("creation_date").toLocalDate().atStartOfDay());
        worker.setEndDate(ZonedDateTime.from(rs.getDate("end_date").toLocalDate()));
        worker.setId(rs.getLong("id"));

        Organization organization = new OrdinaryOrganization();
        organization.setFullName(rs.getString("organization_name"));

        worker.setOrganization(organization);

        return  worker;
    }
}
