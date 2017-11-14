package controllers;

import models.UserHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListServlet", urlPatterns = {"/ListServlet" ,""})
public class ListServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserHelper uh = new UserHelper();
        request.setAttribute("listUser", uh.findAllUser());
        request.getRequestDispatcher("pages/index.jsp").forward(request, response);
    }
}
