package pl.coderslab.controller.customer;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/app/customers/add")
public class AddServlet extends HttpServlet {
    CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/customer/add.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateOfBirthParam = req.getParameter("date_of_birth");
        Date dateOfBirth = dateOfBirthParam.isEmpty() ? null : Date.valueOf(dateOfBirthParam);
        Customer customer = new Customer(
                req.getParameter("first_name"),
                req.getParameter("last_name"),
                dateOfBirth
        );
        customerDao.create(customer);

        resp.sendRedirect("/app/customers");
    }
}
