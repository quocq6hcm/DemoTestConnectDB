package controllers;

import models.UserHelper;
import models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListServlet", urlPatterns = {"/ListServlet"})
public class ListServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Users temp = (Users) request.getSession().getAttribute("loginUser");
        if(temp != null) {
            request.setAttribute("loginUserFullName", temp.getFullName());

            UserHelper uh = new UserHelper();
            request.setAttribute("listUser", uh.findAllUser());
            request.getRequestDispatcher("pages/index.jsp").forward(request, response);
        }
        else
            response.sendRedirect("LoginServlet");

    }
}
