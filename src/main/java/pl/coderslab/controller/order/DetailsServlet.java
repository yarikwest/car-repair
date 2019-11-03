package pl.coderslab.controller.order;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/orders/details")
public class DetailsServlet extends HttpServlet {
    OrderDao orderDao = new OrderDao();
    CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("order", orderDao.read(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("customer", customerDao.findByOrderId(Integer.parseInt(req.getParameter("id"))));
        getServletContext().getRequestDispatcher("/jsp/order/details.jsp")
                .forward(req, resp);
    }
}
