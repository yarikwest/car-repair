package pl.coderslab.controller.vehicle;

import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicles")
public class VehiclesServlet extends HttpServlet {
    VehicleDao vehicleDao = new VehicleDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("vehicles", vehicleDao.findAllByOwnerId(Integer.parseInt(req.getParameter("ownerId"))));
        req.setAttribute("ownerName", req.getParameter("ownerName"));
        req.setAttribute("ownerId", req.getParameter("ownerId"));
        getServletContext().getRequestDispatcher("/jsp/vehicle/vehicles.jsp")
                .forward(req, resp);
    }
}
