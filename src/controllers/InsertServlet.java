package controllers;

import models.UserHelper;
import models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertServlet", urlPatterns = {"/InsertServlet"})
public class InsertServlet extends HttpServlet
{
    UserHelper uh = new UserHelper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println( "sdaf: "+request.getParameter("photo"));
//        uh.postUser(new Users(
//                request.getParameter("username"),
//                request.getParameter("password"),
//                request.getParameter("fullname"),
//                request.getParameter("photo"),
//                request.getParameter("email"),
//                Integer.parseInt(request.getParameter("level")
//                )));
//        response.sendRedirect("ListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
//        response.sendRedirect("pages/insert.jsp");
        request.getRequestDispatcher("pages/insert.jsp").forward(request, response);
    }
}
