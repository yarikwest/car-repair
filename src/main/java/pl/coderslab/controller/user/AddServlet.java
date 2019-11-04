package pl.coderslab.controller.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet("/app/users/add")
public class AddServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(AddServlet.class.getName());
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/user/add.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String admin = req.getParameter("admin");
        boolean isAdmin = "true".equals(admin);
        User user;
        if (!password.equals(password2)) {
            req.setAttribute("error", "Podane hałwa są różne");
            getServletContext().getRequestDispatcher("/jsp/user/add.jsp")
                    .forward(req, resp);
        } else {
            try {
                user = userDao.create(new User(login, password, isAdmin));
                resp.sendRedirect("/app/users");
            } catch (SQLIntegrityConstraintViolationException e) {
                LOGGER.error(e);
                if (e.getMessage().contains("Duplicate entry")) {
                    req.setAttribute("error", "Użytkownik z takim loginem już istnieje");
                    getServletContext().getRequestDispatcher("/jsp/user/add.jsp")
                            .forward(req, resp);
                } else {
                    req.setAttribute("error", "Coś poszło nie tak :(");
                    getServletContext().getRequestDispatcher("/jsp/user/add.jsp")
                            .forward(req, resp);
                }
            }
        }
    }
}
