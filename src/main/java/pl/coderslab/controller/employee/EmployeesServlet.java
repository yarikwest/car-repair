package pl.coderslab.controller.employee;

import pl.coderslab.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employees")
public class EmployeesServlet extends HttpServlet {
    private EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employees", employeeDao.findAll());
        getServletContext().getRequestDispatcher("/jsp/employee/employees.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
