package controllers;

import models.UserHelper;
import models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    UserHelper uh = new UserHelper();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username;
        String password;
        username = request.getParameter("username");
        password = request.getParameter("password");
        Users check = uh.login(username, password);
        if (check != null)
        {
         //   request.getRequestDispatcher("ListServlet").forward(request, response);
            request.getSession().setAttribute("loginUser", check);
            response.sendRedirect("ListServlet");
        }
        else
        {
            request.getRequestDispatcher("pages/login.jsp").include(request, response);
            response.getWriter().println("<h2>Username or password is invalid </h2>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/login.jsp").forward(request, response);
    }


}
