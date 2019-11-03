package pl.coderslab.controller.employee;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/app/employees/edit")
public class EditServlet extends HttpServlet {
    private EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employee", employeeDao.read(Integer.parseInt(req.getParameter("id"))));
        getServletContext().getRequestDispatcher("/jsp/employee/edit.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String costOfWorkHourParam = req.getParameter("cost_of_work_hour");
        BigDecimal costOfWorkHour = costOfWorkHourParam.isEmpty() ? null : new BigDecimal(costOfWorkHourParam);

        Employee employee = new Employee(
                req.getParameter("first_name"),
                req.getParameter("last_name"),
                req.getParameter("address"),
                req.getParameter("telephone"),
                req.getParameter("note"),
                costOfWorkHour
        );
        employee.setId(Integer.parseInt(req.getParameter("id")));

        employeeDao.update(employee);
        resp.sendRedirect("/app/employees");
    }
}
