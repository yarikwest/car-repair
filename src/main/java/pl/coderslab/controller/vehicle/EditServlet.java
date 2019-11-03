package pl.coderslab.controller.vehicle;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/app/vehicles/edit")
public class EditServlet extends HttpServlet {
    VehicleDao vehicleDao = new VehicleDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("vehicle", vehicleDao.read(Integer.parseInt(req.getParameter("id"))));
        getServletContext().getRequestDispatcher("/jsp/vehicle/edit.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String yearOfProdParam = req.getParameter("year_of_prod");
        String nextInspectionParam = req.getParameter("next_inspection");
        Short yearOfProd = yearOfProdParam.isEmpty() ? 0 : Short.valueOf(yearOfProdParam);
        Date nextInspection = nextInspectionParam.isEmpty() ? null : Date.valueOf(nextInspectionParam);
        Vehicle vehicle = new Vehicle(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("model"),
                req.getParameter("brand"),
                yearOfProd,
                req.getParameter("registry"),
                nextInspection,
                Integer.parseInt(req.getParameter("owner_id"))
        );
        vehicleDao.update(vehicle);

        resp.sendRedirect("/app/vehicles?ownerId=" + req.getParameter("owner_id"));
    }
}
