import models.UserHelper;
import models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet
{
    UserHelper uh = new UserHelper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        uh.putUser(new Users(
                request.getParameter("username"),
                request.getParameter("password"),
                request.getParameter("fullname"),
                request.getParameter("photo"),
                request.getParameter("email"),
                Integer.parseInt(request.getParameter("level")
                )));
        response.sendRedirect("ListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Users temp = uh.findUserByUsername(request.getParameter("username"));
        request.setAttribute("user" , temp);
        request.getRequestDispatcher("pages/update.jsp").forward(request, response);
    }
}
