package pl.coderslab.controller.order;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.StatusDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Map;

@WebServlet("/app/orders/add")
public class AddServlet extends HttpServlet {
    private EmployeeDao employeeDao = new EmployeeDao();
    private StatusDao statusDao = new StatusDao();
    private VehicleDao vehicleDao = new VehicleDao();
    private OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employees", employeeDao.findAll());
        req.setAttribute("statuses", statusDao.findAll());
        req.setAttribute("vehicles", vehicleDao.findAll());
        getServletContext().getRequestDispatcher("/jsp/order/add.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> strings = req.getParameterMap();

        Date acceptRepair = strings.get("accept_repair")[0].isEmpty() ? null : Date.valueOf(strings.get("accept_repair")[0]);
        Date planStartRepair = strings.get("plan_start_repair")[0].isEmpty() ? null : Date.valueOf(strings.get("plan_start_repair")[0]);
        Date startRepair = strings.get("start_repair")[0].isEmpty() ? null : Date.valueOf(strings.get("start_repair")[0]);
        Date endRepair = strings.get("end_repair")[0].isEmpty() ? null : Date.valueOf(strings.get("end_repair")[0]);
        Employee employee = strings.get("employee")[0].isEmpty() ? new Employee() : employeeDao.read(Integer.parseInt(strings.get("employee")[0]));
        String problemDescription = strings.get("problem_description")[0];
        String repairDescription = strings.get("repair_description")[0];
        Status status = strings.get("status")[0].isEmpty() ? new Status() : statusDao.read(Integer.parseInt(strings.get("status")[0]));
        Vehicle vehicle = strings.get("vehicle")[0].isEmpty() ? new Vehicle() : vehicleDao.read(Integer.parseInt(strings.get("vehicle")[0]));
        BigDecimal costOfRepair = strings.get("cost_of_repair")[0].isEmpty() ? null : new BigDecimal(strings.get("cost_of_repair")[0]);
        BigDecimal costOfParts = strings.get("cost_of_parts")[0].isEmpty() ? null : new BigDecimal(strings.get("cost_of_parts")[0]);
        BigDecimal costOfWorkHour = strings.get("cost_of_work_hour")[0].isEmpty() ? null : new BigDecimal(strings.get("cost_of_work_hour")[0]);
        BigDecimal numberWorkHour = strings.get("number_work_hour")[0].isEmpty() ? null : new BigDecimal(strings.get("number_work_hour")[0]);

        orderDao.create(new Order(acceptRepair, planStartRepair, startRepair, endRepair, employee, problemDescription,
                repairDescription, status, vehicle, costOfRepair, costOfParts, costOfWorkHour, numberWorkHour));

        resp.sendRedirect("/app/orders");
    }
}
