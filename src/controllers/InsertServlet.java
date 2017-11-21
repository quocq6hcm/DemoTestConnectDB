package controllers;

import models.UserHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "InsertServlet", urlPatterns = {"/InsertServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,    // 10 MB
        maxFileSize = 1024 * 1024 * 50,          // 50 MB
        maxRequestSize = 1024 * 1024 * 100,      // 100 MB
        location = "/")
public class InsertServlet extends HttpServlet
{
    UserHelper uh = new UserHelper();

    private static final long serialVersionUID = 205242440643911308L;
    private static final String UPLOAD_DIR = "/web/resources/images";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String applicationPath = request.getServletContext().getRealPath("");
        String pathNew = applicationPath.substring(0, applicationPath.length() - 53);

        System.out.println("pathnew : " + pathNew);

        String uploadFilePath = pathNew + UPLOAD_DIR;

        File currDir = new File("");
        String path = currDir.getAbsolutePath();
        File fileSaveDir = new File(uploadFilePath);

        if (!fileSaveDir.exists())
        {
            fileSaveDir.mkdirs();
        }

        System.out.println("upload file directory = " + fileSaveDir.getAbsolutePath());
//
        Part filePart = request.getPart("photo");
        String fileName = getSubmitFileName(filePart);
        System.out.println("file name: " + fileName);
        System.out.println("ahihi: " + uploadFilePath + "/" + fileName);


        filePart.write(uploadFilePath + File.separator + fileName);


//        System.out.println("sdaf: " + request.getParameter("photo"));
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

    private String getSubmitFileName(Part part)
    {
        for (String cd : part.getHeader("content-disposition").split(";"))
        {
            if (cd.trim().startsWith("filename"))
            {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }
}
