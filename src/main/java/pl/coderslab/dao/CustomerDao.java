package pl.coderslab.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.coderslab.model.Customer;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static final Logger LOGGER = LogManager.getLogger(Customer.class.getName());

    private static final String CREATE_QUERY = "insert into customers (first_name, last_name, date_of_birth) value (?,?,?)";
    private static final String READ_QUERY = "select * from customers where id = ?";
    private static final String UPDATE_QUERY = "update customers set first_name = ?, last_name = ?, date_of_birth = ? where id = ?";
    private static final String DELETE_QUERY = "delete from customers where id = ?";
    private static final String FIND_ALL_QUERY = "select * from customers";
    private static final String FIND_ALL_BY_LAST_NAME_QUERY = "select * from customers where last_name like ?";
    private static final String FIND_BY_ORDER_ID_QUERY = "select c.* from customers c left join vehicles v on" +
            " c.id = v.owner_id left join orders o on v.id = o.vehicle_id where o.id = ?";

    public Customer create(Customer customer) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setDate(3, customer.getDateOfBirth());
            LOGGER.info(preparedStatement);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                customer.setId(resultSet.getInt(1));
            }
            resultSet.close();
            return customer;
        } catch (SQLException e) {
            LOGGER.error(e);
            return null;
        }
    }

    public Customer read(int id) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_QUERY)) {
            preparedStatement.setInt(1, id);
            LOGGER.info(preparedStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setDateOfBirth(resultSet.getDate("date_of_birth"));
                resultSet.close();
                return customer;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Row with id:" + id + " not exist");
        return null;
    }

    public void update(Customer customer) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setDate(3, customer.getDateOfBirth());
            preparedStatement.setInt(4, customer.getId());
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

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                customers.add(new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("date_of_birth")
                ));
            }
            return customers;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return customers;
    }

    public List<Customer> findAllByLastName(String lastName) {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_LAST_NAME_QUERY)) {
            preparedStatement.setString(1, "%" + lastName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                customers.add(new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("date_of_birth")
                ));
            }
            resultSet.close();
            return customers;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Rows with %" + lastName + "% not exist");
        return customers;
    }

    public Customer findByOrderId(int orderId) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ORDER_ID_QUERY)) {
            preparedStatement.setInt(1, orderId);
            LOGGER.info(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setDateOfBirth(resultSet.getDate("date_of_birth"));
                resultSet.close();
                return customer;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Row with order_id:" + orderId + " not exist");
        return null;
    }
}
