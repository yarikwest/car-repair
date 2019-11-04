package pl.coderslab.controller.auth;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;
import pl.coderslab.utils.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userDao.readByLogin(login);
        if (user != null && user.getLogin().equals(login) && PasswordUtil.checkPassword(password, user.getPassword())) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/app");
        } else {
            req.setAttribute("foul", true);
            getServletContext().getRequestDispatcher("/jsp/login.jsp")
                    .forward(req, resp);
        }
    }
}
