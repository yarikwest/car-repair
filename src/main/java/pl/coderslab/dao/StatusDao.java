package pl.coderslab.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.coderslab.model.Status;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {
    private static final Logger LOGGER = LogManager.getLogger(StatusDao.class.getName());

    private static final String CREATE_QUERY = "insert into statuses (title) value (?)";
    private static final String READ_QUERY = "select * from statuses where id = ?";
    private static final String UPDATE_QUERY = "update statuses set title = ? where id = ?";
    private static final String DELETE_QUERY = "delete from statuses where id = ?";
    private static final String FIND_ALL_QUERY = "select * from statuses";

    public Status create(Status status) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, status.getTitle());
            LOGGER.info(preparedStatement);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                status.setId(resultSet.getInt(1));
            }
            resultSet.close();
            return status;
        } catch (SQLException e) {
            LOGGER.error(e);
            return null;
        }
    }

    public Status read(int id) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_QUERY)) {
            preparedStatement.setInt(1, id);
            LOGGER.info(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Status status = new Status(
                        id,
                        resultSet.getString("title")
                );
                resultSet.close();
                return status;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Row with id:" + id + " not exist");
        return null;
    }

    public void update(Status status) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, status.getTitle());
            preparedStatement.setInt(2, status.getId());
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

    public List<Status> findAll() {
        List<Status> statuses = new ArrayList<>();

        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                statuses.add(new Status(
                        resultSet.getInt("id"),
                        resultSet.getString("title")
                ));
            }
            return statuses;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return statuses;
    }
}
