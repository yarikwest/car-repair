package pl.coderslab.controller.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;
import pl.coderslab.utils.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet("/app/users/details/change-login")
public class ChangeLoginServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(AddServlet.class.getName());
    UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idParam = Integer.parseInt(req.getParameter("id"));
        String loginParam = req.getParameter("login");
        User user = userDao.read(idParam);

        if (loginParam == null) {
            req.setAttribute("error", "Podaj login");
            getServletContext().getRequestDispatcher("/jsp/user/details.jsp")
                    .forward(req, resp);
        } else {
            user.setLogin(loginParam);
            try {
                userDao.update(user);
                if (((User) req.getSession().getAttribute("user")).isAdmin()) {
                    resp.sendRedirect("/app/users/edit?id=" + idParam);
                } else {
                    resp.sendRedirect("/app/users/details");
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                LOGGER.error(e);
                if (e.getMessage().contains("Duplicate entry")) {
                    req.setAttribute("error", "Użytkownik z takim loginem już istnieje");
                    req.setAttribute("userEdit", userDao.read(idParam));
                    getServletContext().getRequestDispatcher("/jsp/user/details.jsp")
                            .forward(req, resp);
                } else {
                    req.setAttribute("error", "Coś poszło nie tak :(");
                    req.setAttribute("userEdit", userDao.read(idParam));
                    getServletContext().getRequestDispatcher("/jsp/user/details.jsp")
                            .forward(req, resp);
                }
            }
        }
    }
}
