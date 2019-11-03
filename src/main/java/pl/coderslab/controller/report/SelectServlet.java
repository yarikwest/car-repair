package pl.coderslab.controller.report;

import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Map;

@WebServlet("/app/reports")
public class SelectServlet extends HttpServlet {
    OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/report/select.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startDateParam = req.getParameter("start_date");
        String endDateParam = req.getParameter("end_date");
        String typeReportParam = req.getParameter("report_type");
        if (startDateParam.isEmpty() & endDateParam.isEmpty()) {
            req.setAttribute("empty_fields", true);
            getServletContext().getRequestDispatcher("/jsp/report/select.jsp")
                    .forward(req, resp);
        } else {
            if (typeReportParam.equals("report_hours")) {
                Map<String, BigDecimal> map = orderDao.calcWorkHour(Date.valueOf(startDateParam), Date.valueOf(endDateParam));
                req.setAttribute("map", map);
                getServletContext().getRequestDispatcher("/jsp/report/report-hours.jsp")
                        .forward(req, resp);
            } else {
                Map<Date, BigDecimal> map = orderDao.calcProfit(Date.valueOf(startDateParam), Date.valueOf(endDateParam));
                double sum = 0;
                for (BigDecimal value : map.values()) {
                    sum += value.doubleValue();
                }
                req.setAttribute("sum", sum);
                req.setAttribute("map", map);
                getServletContext().getRequestDispatcher("/jsp/report/report-profit.jsp")
                        .forward(req, resp);
            }
        }
    }
}
