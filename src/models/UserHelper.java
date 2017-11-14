package models;

// ****************************************** ************************************
// **************************    ************ User: MiTom
// *****************************    ********* Phone: 0966 941 840
// ********************************    ****** Email: 
// ****************************************** ************************************
// *****       ********       ******    ***** Package: models
// *****        ******        ******    ***** Project: DemoTestConnectDB
// *****    *    ****    *    ******    ***** Date: 14-Nov-17
// *****    **    **    **    ******    ***** Time: 09:24
// *****    ***        ***    ******    ***** Name: UserHelper
// *****    **************    ******    ***** ************************************
// *****    **************    ******    ***** Created by IntelliJ IDEA.
// ****************************************** ************************************

import javax.xml.registry.infomodel.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserHelper
{
    private List<Users> listUser = new ArrayList<>();
    private DBHandler db = new DBHandler();
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public List<Users> findAllUser()
    {
        try
        {
            this.st = db.openCnnDB().createStatement();
            this.rs = st.executeQuery("SELECT  * from Users");
            while (rs.next())
            {
                this.listUser.add(new Users(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        Integer.parseInt(rs.getString(6))));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            db.closeCnnDB();
        }
        return listUser;
    }

    public void postUser(Users u)
    {
        try
        {
            pst = db.openCnnDB().prepareStatement("insert into Users VALUES (?,?,?,?,?,?)");
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setString(3, u.getFullName());
            pst.setString(4, u.getPhoto());
            pst.setString(5, u.getEmail());
            pst.setInt(6, u.getLevel());
            pst.execute();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void putUser(Users u)
    {
        try
        {
            pst = db.openCnnDB().prepareStatement("update Users set password = ?, fullname = ? , photo = ? , email = ? , level = ? where username = ?");
            //?? chú ý tại sao xuống hàng thì k chạy được....
            pst.setString(1, u.getPassword());
            pst.setString(2, u.getFullName());
            pst.setString(3, u.getPhoto());
            pst.setString(4, u.getEmail());
            pst.setInt(5, u.getLevel());
            pst.setString(6, u.getUsername());
            pst.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args)
//    {
//        UserHelper uh = new UserHelper();
//        uh.putUser( new Users("ahihi","ahihi1","ahihi1","ahihi1.jpg","ahihi1@gmail.com",4));
//    }
}
