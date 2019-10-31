package pl.coderslab.controller.order;

import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {
    OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeId = req.getParameter("employeeId");
        String customerId = req.getParameter("customerId");
        if (employeeId != null) {
            req.setAttribute("orders", orderDao.findAllByEmployeeId(Integer.parseInt(employeeId)));
            req.setAttribute("employeeName", req.getParameter("employeeName"));
        } else if (customerId != null) {
            req.setAttribute("orders", orderDao.findAllByCustomerId(Integer.parseInt(customerId)));
            req.setAttribute("customerName", req.getParameter("customerName"));
        } else {
            req.setAttribute("orders", orderDao.findAll());
        }
        getServletContext().getRequestDispatcher("/jsp/order/orders.jsp")
                .forward(req, resp);
    }
}
