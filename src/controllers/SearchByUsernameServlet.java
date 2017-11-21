package controllers;

import models.UserHelper;
import models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchByUsernameServlet" , urlPatterns = {"/SearchByUsernameServlet"})
public class SearchByUsernameServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserHelper uh = new UserHelper();
        List<Users> list = new ArrayList<>();
        String temp = request.getParameter("search");
        if (!temp.isEmpty())
        {
            list.add(uh.findUserByUsername(temp));
        }
        request.setAttribute("listUser", list);
        request.getRequestDispatcher("pages/index.jsp").forward(request, response);
    }
}
