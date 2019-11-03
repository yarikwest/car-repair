package pl.coderslab.controller.employee;

import pl.coderslab.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/employees/delete")
public class DeleteServlet extends HttpServlet {
    EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        employeeDao.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/app/employees");
    }
}
