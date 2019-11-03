package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/customers")
public class CustomersServlet extends HttpServlet {
    CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customers", customerDao.findAll());
        getServletContext().getRequestDispatcher("/jsp/customer/customers.jsp")
                .forward(req, resp);
    }
}
