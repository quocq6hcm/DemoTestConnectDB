package models;

// ****************************************** ************************************
// **************************    ************ User: MiTom
// *****************************    ********* Phone: 0966 941 840
// ********************************    ****** Email: 
// ****************************************** ************************************
// *****       ********       ******    ***** Package: models
// *****        ******        ******    ***** Project: DemoTestConnectDB
// *****    *    ****    *    ******    ***** Date: 14-Nov-17
// *****    **    **    **    ******    ***** Time: 09:02
// *****    ***        ***    ******    ***** Name: DBHandler
// *****    **************    ******    ***** ************************************
// *****    **************    ******    ***** Created by IntelliJ IDEA.
// ****************************************** ************************************

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler
{
    private Connection cnnDB;

     Connection openCnnDB()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnnDB = DriverManager.getConnection("jdbc:sqlserver://localhost;database=TestDB;username=sa;password=1234");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            cnnDB = null;
        }
        return cnnDB;
    }

     void closeCnnDB()
    {
        if (cnnDB != null)
        {
            try
            {
                cnnDB.close();
                cnnDB = null;
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

}
