package servlet;

import payload.UsersResponse;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        LoginService service = new LoginService();
        UsersResponse detailUser = service.login(email, pass);

        if (detailUser != null) {
            HttpSession session = req.getSession();
            session.setAttribute("detailUser", detailUser);
            resp.sendRedirect(req.getContextPath() + "/detail");
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
