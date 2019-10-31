package pl.coderslab.controller.vehicle;

import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicles/delete")
public class DeleteServlet extends HttpServlet {
    VehicleDao vehicleDao = new VehicleDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        vehicleDao.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/vehicles?ownerId=" + req.getParameter("ownerId"));
    }
}
