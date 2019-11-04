package pl.coderslab.controller.user;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/users/details")
public class DetailsServlet extends HttpServlet {
    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        user = userDao.read(user.getId());
        req.getSession().setAttribute("user", user);
        req.setAttribute("userEdit", user);
        getServletContext().getRequestDispatcher("/jsp/user/details.jsp")
                .forward(req, resp);
    }
}
