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

@WebServlet("/app/users/details/change-password")
public class ChangePasswordServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(AddServlet.class.getName());
    UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idParam = Integer.parseInt(req.getParameter("id"));
        String oldPasswordParam = req.getParameter("oldPassword");
        String passwordParam = req.getParameter("password");
        String password2Param = req.getParameter("password2");
        User user = userDao.read(idParam);

        if (passwordParam == null || passwordParam.isEmpty() || !passwordParam.equals(password2Param)) {
            req.setAttribute("error", "Podane nowe hałwa są różne");
            getServletContext().getRequestDispatcher("/jsp/user/details.jsp")
                    .forward(req, resp);
        } else if (!PasswordUtil.checkPassword(oldPasswordParam, user.getPassword())) {
            req.setAttribute("error", "Stare hasło nie poprawne");
            getServletContext().getRequestDispatcher("/jsp/user/details.jsp")
                    .forward(req, resp);
        } else {
            user.setPassword((PasswordUtil.createHash(passwordParam)));
            try {
                userDao.update(user);
                if (((User) req.getSession().getAttribute("user")).isAdmin()) {
                    resp.sendRedirect("/app/users/edit?id=" + idParam);
                } else {
                    resp.sendRedirect("/app/users/details");
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                LOGGER.error(e);
                req.setAttribute("error", "Coś poszło nie tak :(");
                req.setAttribute("userEdit", userDao.read(idParam));
                getServletContext().getRequestDispatcher("/jsp/user/details.jsp")
                        .forward(req, resp);
            }
        }
    }
}
