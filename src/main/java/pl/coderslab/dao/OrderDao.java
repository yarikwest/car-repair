package pl.coderslab.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.coderslab.model.Order;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDao {
    private StatusDao statusDao = new StatusDao();
    private EmployeeDao employeeDao = new EmployeeDao();
    private VehicleDao vehicleDao = new VehicleDao();

    private static final Logger LOGGER = LogManager.getLogger(OrderDao.class.getName());

    private static final String CREATE_QUERY = "insert into orders (accept_repair, plan_start_repair, start_repair" +
            ", end_repair, employee_id, problem_description, repair_description, status_id, vehicle_id, cost_of_repair" +
            ", cost_of_parts, cost_of_work_hour, number_work_hour) value (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String READ_QUERY = "select * from orders where id = ?";
    private static final String UPDATE_QUERY = "update orders set accept_repair = ?, plan_start_repair = ?" +
            ", start_repair = ?, end_repair = ?, employee_id = ?, problem_description = ?, repair_description = ?" +
            ", status_id = ?, vehicle_id = ?, cost_of_repair = ?, cost_of_parts = ?, cost_of_work_hour = ?" +
            ", number_work_hour = ? where id = ?";
    private static final String DELETE_QUERY = "delete from orders where id = ?";
    private static final String FIND_ALL_QUERY = "select * from orders";
    private static final String FIND_ALL_BY_VEHICLE_ID_QUERY = "select * from orders where vehicle_id = ?";
    private static final String FIND_ALL_BY_STATUS_ID_QUERY = "select * from orders where status_id = ?";
    private static final String FIND_ALL_BY_EMPLOYEE_ID_AND_STATUS_QUERY = "select * from orders where " +
            "employee_id = ? and status_id = 3";
    private static final String CALC_WORK_HOUR_QUERY = "select concat(e.first_name, ' ', e.last_name) as name" +
            ", SUM(o.number_work_hour) as sum_work_hour from orders o join employees e on o.employee_id = e.id" +
            " where o.start_repair between cast(? as date) and cast(? as date) group by o.employee_id";
    private static final String CALC_PROFIT_QUERY = "select sum(cost_of_repair - (cost_of_parts +" +
            " (cost_of_work_hour * number_work_hour))) as profit from orders where end_repair between cast(? as date)" +
            " and cast(? as date)";

    public Order create(Order order) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, order.getAcceptRepair());
            preparedStatement.setDate(2, order.getPlanStartRepair());
            preparedStatement.setDate(3, order.getStartRepair());
            preparedStatement.setDate(4, order.getEndRepair());
            preparedStatement.setInt(5, order.getEmployee().getId());
            preparedStatement.setString(6, order.getProblemDescription());
            preparedStatement.setString(7, order.getRepairDescription());
            preparedStatement.setInt(8, order.getStatus().getId());
            preparedStatement.setInt(9, order.getVehicle().getId());
            preparedStatement.setDouble(10, order.getCostOfRepair());
            preparedStatement.setDouble(11, order.getCostOfParts());
            preparedStatement.setDouble(12, order.getCostOfWorkHour());
            preparedStatement.setDouble(13, order.getNumberWorkHour());
            LOGGER.info(preparedStatement);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setId(resultSet.getInt(1));
            }
            resultSet.close();
            return order;
        } catch (SQLException e) {
            LOGGER.error(e);
            return null;
        }
    }

    public Order read(int id) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_QUERY)) {
            preparedStatement.setInt(1, id);
            LOGGER.info(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Order order = createOrder(resultSet);
                resultSet.close();
                return order;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Row with id:" + id + " not exist");
        return null;
    }

    public void update(Order order) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setDate(1, order.getAcceptRepair());
            preparedStatement.setDate(2, order.getPlanStartRepair());
            preparedStatement.setDate(3, order.getStartRepair());
            preparedStatement.setDate(4, order.getEndRepair());
            preparedStatement.setInt(5, order.getEmployee().getId());
            preparedStatement.setString(6, order.getProblemDescription());
            preparedStatement.setString(7, order.getRepairDescription());
            preparedStatement.setInt(8, order.getStatus().getId());
            preparedStatement.setInt(9, order.getVehicle().getId());
            preparedStatement.setDouble(10, order.getCostOfRepair());
            preparedStatement.setDouble(11, order.getCostOfParts());
            preparedStatement.setDouble(12, order.getCostOfWorkHour());
            preparedStatement.setDouble(13, order.getNumberWorkHour());
            preparedStatement.setInt(14, order.getId());
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

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                orders.add(createOrder(resultSet));
            }
            return orders;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return orders;
    }

    public List<Order> findAllByVehicleId(int vehicleId) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_VEHICLE_ID_QUERY)) {
            preparedStatement.setInt(1, vehicleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                orders.add(createOrder(resultSet));
            }
            resultSet.close();
            return orders;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Rows with vehicle_id:" + vehicleId + " not exist");
        return orders;
    }

    public List<Order> findAllByStatusId(int statusId) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_STATUS_ID_QUERY)) {
            preparedStatement.setInt(1, statusId);
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                orders.add(createOrder(resultSet));
            }
            resultSet.close();
            return orders;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Rows with vehicle_id:" + statusId + " not exist");
        return orders;
    }

    public List<Order> findAllByEmployeeId(int employeeId) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_EMPLOYEE_ID_AND_STATUS_QUERY)) {
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                orders.add(createOrder(resultSet));
            }
            resultSet.close();
            return orders;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Rows with employee_id:" + employeeId + " and status 'W naprawie' not exist");
        return orders;
    }

    public Map<String, Double> calcWorkHour(Date startDate, Date endDate) {
        Map<String, Double> map = new HashMap<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(CALC_WORK_HOUR_QUERY)) {
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, endDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info(preparedStatement);
            while (resultSet.next()) {
                map.put(
                        resultSet.getString("name"),
                        resultSet.getDouble("sum_work_hour")
                );
            }
            resultSet.close();
            return map;
        } catch (SQLException e) {
            LOGGER.error(e);
            return map;
        }
    }

    public Double calcProfit(Date startDate, Date endDate) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(CALC_PROFIT_QUERY)) {
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, endDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info(preparedStatement);
            if (resultSet.next()) {
                double profit = resultSet.getDouble("profit");
                resultSet.close();
                return profit;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    //Method for creating new Order with his all instance variables
    private Order createOrder(ResultSet resultSet) throws SQLException {
        return new Order(
                resultSet.getInt("id"),
                resultSet.getDate("accept_repair"),
                resultSet.getDate("plan_start_repair"),
                resultSet.getDate("start_repair"),
                resultSet.getDate("end_repair"),
                employeeDao.read(resultSet.getInt("employee_id")),
                resultSet.getString("problem_description"),
                resultSet.getString("repair_description"),
                statusDao.read(resultSet.getInt("status_id")),
                vehicleDao.read(resultSet.getInt("vehicle_id")),
                resultSet.getDouble("cost_of_repair"),
                resultSet.getDouble("cost_of_parts"),
                resultSet.getDouble("cost_of_work_hour"),
                resultSet.getDouble("number_work_hour")
        );
    }
}
