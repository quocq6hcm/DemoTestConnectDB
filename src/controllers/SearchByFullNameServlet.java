package controllers;

import models.UserHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchByFullNameServlet" , urlPatterns = {"/SearchByFullName"})
public class SearchByFullNameServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserHelper uh = new UserHelper();

        String temp = request.getParameter("searchFullname").isEmpty() ? "" : request.getParameter("searchFullname");
        request.setAttribute("searchFullname",temp);

        request.setAttribute("listUser", uh.findUsersByFullname(request.getParameter("searchFullname")));
        request.getRequestDispatcher("pages/index.jsp").forward(request, response);

    }
}
