package pl.coderslab.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.coderslab.model.Employee;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeDao.class.getName());

    private static final String CREATE_QUERY = "insert into employees (first_name, last_name, address, telephone" +
            ", note, cost_of_work_hour) value (?,?,?,?,?,?)";
    private static final String READ_QUERY = "select * from employees where id = ?";
    private static final String UPDATE_QUERY = "update employees set first_name = ?, last_name = ?, address = ?" +
            ", telephone = ?, note = ?, cost_of_work_hour = ? where id = ?";
    private static final String DELETE_QUERY = "delete from employees where id = ?";
    private static final String FIND_ALL_QUERY = "select * from employees";

    public Employee create(Employee employee) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getTelephone());
            preparedStatement.setString(5, employee.getNote());
            preparedStatement.setDouble(6, employee.getCostOfWorkHour());
            LOGGER.info(preparedStatement);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
            }
            resultSet.close();
            return employee;
        } catch (SQLException e) {
            LOGGER.error(e);
            return null;
        }
    }

    public Employee read(int id) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_QUERY)) {
            preparedStatement.setInt(1, id);
            LOGGER.info(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAddress(resultSet.getString("address"));
                employee.setTelephone(resultSet.getString("telephone"));
                employee.setNote(resultSet.getString("note"));
                employee.setCostOfWorkHour(resultSet.getDouble("cost_of_work_hour"));

                resultSet.close();
                return employee;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Row with id:" + id + " not exist");
        return null;
    }

    public void update(Employee employee) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getTelephone());
            preparedStatement.setString(5, employee.getNote());
            preparedStatement.setDouble(6, employee.getCostOfWorkHour());
            preparedStatement.setInt(7, employee.getId());
            LOGGER.info(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void delete(int id) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setInt(1, id);
            LOGGER.info(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("address"),
                        resultSet.getString("telephone"),
                        resultSet.getString("note"),
                        resultSet.getDouble("cost_of_work_hour")
                ));
            }
            return employees;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return employees;
    }
}
