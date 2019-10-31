package pl.coderslab.controller.vehicle;

import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicles/history")
public class RepairsHistoryServlet extends HttpServlet {
    OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("orders", orderDao.findAllByVehicleId(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("vehicleName", req.getParameter("vehicleName"));
        getServletContext().getRequestDispatcher("/jsp/vehicle/repair-history.jsp")
                .forward(req, resp);
    }
}
