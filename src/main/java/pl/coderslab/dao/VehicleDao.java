package pl.coderslab.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.coderslab.model.Vehicle;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private static final Logger LOGGER = LogManager.getLogger(VehicleDao.class.getName());

    private static final String CREATE_QUERY = "insert into vehicles (model, brand, year_of_prod, registry" +
            ", next_inspection, owner_id) value (?,?,?,?,?,?)";
    private static final String READ_QUERY = "select * from vehicles where id = ?";
    private static final String UPDATE_QUERY = "update vehicles set model = ?, brand = ?, year_of_prod = ?" +
            ", registry = ?, next_inspection = ?, owner_id = ? where id = ?";
    private static final String DELETE_QUERY = "delete from vehicles where id = ?";
    private static final String FIND_ALL_QUERY = "select * from vehicles";
    private static final String FIND_ALL_BY_OWNER_ID_QUERY = "select * from vehicles where owner_id = ?";

    public Vehicle create(Vehicle vehicle) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, vehicle.getModel());
            preparedStatement.setString(2, vehicle.getBrand());
            preparedStatement.setDate(3, vehicle.getYearOfProd());
            preparedStatement.setString(4, vehicle.getRegistry());
            preparedStatement.setDate(5, vehicle.getNextInspection());
            preparedStatement.setInt(6, vehicle.getOwnerId());
            LOGGER.info(preparedStatement);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                vehicle.setId(resultSet.getInt(1));
            }
            resultSet.close();
            return vehicle;
        } catch (SQLException e) {
            LOGGER.error(e);
            return null;
        }
    }

    public Vehicle read(int id) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_QUERY)) {
            preparedStatement.setInt(1, id);
            LOGGER.info(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setYearOfProd(resultSet.getDate("year_of_prod"));
                vehicle.setRegistry(resultSet.getString("registry"));
                vehicle.setNextInspection(resultSet.getDate("next_inspection"));
                vehicle.setOwnerId(resultSet.getInt("owner_id"));

                resultSet.close();
                return vehicle;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Row with id:" + id + " not exist");
        return null;
    }

    public void update(Vehicle vehicle) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, vehicle.getModel());
            preparedStatement.setString(2, vehicle.getBrand());
            preparedStatement.setDate(3, vehicle.getYearOfProd());
            preparedStatement.setString(4, vehicle.getRegistry());
            preparedStatement.setDate(5, vehicle.getNextInspection());
            preparedStatement.setInt(6, vehicle.getOwnerId());
            preparedStatement.setInt(7, vehicle.getId());
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

    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                vehicles.add(new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getString("brand"),
                        resultSet.getDate("year_of_prod"),
                        resultSet.getString("registry"),
                        resultSet.getDate("next_inspection"),
                        resultSet.getInt("owner_id")
                ));
            }
            return vehicles;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return vehicles;
    }

    public List<Vehicle> findAllByOwnerId(int ownerId) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_OWNER_ID_QUERY)) {
            preparedStatement.setInt(1, ownerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                vehicles.add(new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getString("brand"),
                        resultSet.getDate("year_of_prod"),
                        resultSet.getString("registry"),
                        resultSet.getDate("next_inspection"),
                        resultSet.getInt("owner_id")
                ));
            }
            resultSet.close();
            return vehicles;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Rows with owner_id:" + ownerId + " not exist");
        return vehicles;
    }
}
