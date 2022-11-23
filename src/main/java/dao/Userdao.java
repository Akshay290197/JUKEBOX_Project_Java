package dao;

import JukeboxException.Jukeboxexception;
import entity.User;
import Connection.*;

import java.sql.*;

public class Userdao implements UserdaoInterface {

    @Override
    public void addUser(User u) throws Jukeboxexception, SQLException, ClassNotFoundException {
        String query = null;
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        query = "insert into user(userId,userName,password) values(?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, u.getUserId());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getPassword());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new Jukeboxexception("User Name Already Available, try another user name");
        }
    }

    @Override
    public void deleteUser(int userId,String password) throws SQLException, ClassNotFoundException, Jukeboxexception {
        String query = "delete from user where userId = ? and password = ?";
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,userId);
            ps.setString(2,password);
            ps.executeUpdate();
            /*if(ps.executeUpdate()!=1)
            {
                throw new Jukeboxexception("Your Details Not Match With Existing Details,Please Check Your Details");
            }*/
        }
        catch(SQLException e)
        {
            throw new Jukeboxexception("Your Details Not Match With Existing Details,Please Check Your Details");
        }
    }

    @Override
    public void updateUserName(int userId,String password,String userName) throws SQLException, ClassNotFoundException, Jukeboxexception {
        String query = "update user set username = ? where userid = ? and password = ?";
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        try{
            ps = con.prepareStatement(query);
            ps.setString(1,userName);
            ps.setInt(2,userId);
            ps.setString(3,password);
            ps.executeUpdate();
            if(ps.executeUpdate()!=1)
            {
                throw new Jukeboxexception("Your Details Not Match With Existing Details,Please Check Your Details");
            }
        }
        catch(SQLException | Jukeboxexception e)
        {
            throw new RuntimeException("And Try Again");
        }
    }

    @Override
    public void updateUserPassword(int userId, String password, String newPassword) throws SQLException, ClassNotFoundException, Jukeboxexception {
        String query = "update user set password = ? where userid = ? and password = ?";
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        try{
            ps = con.prepareStatement(query);
            ps.setString(1,newPassword);
            ps.setInt(2,userId);
            ps.setString(3,password);
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();
    }

    @Override
    public void retrieveUser(int userId, String password) throws SQLException, ClassNotFoundException, Jukeboxexception {
        int uid = 0;
        String uName = null;
        String pass = null;

        String query = "select userid,username,password from user where userid = ? and password = ?";
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,userId);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                uid = rs.getInt(1);
                uName = rs.getString(2);
                pass = rs.getString(3);
                System.out.format("%-20s %-20s %-20s","User ID","User Name","Password");
                System.out.println();
                System.out.format("%-20s %-20s %-20s",uid,uName,pass);
                System.out.println();
            }
            if(uid==0)
            {
                System.out.println("Enter correct Details");
                System.out.println();
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();
    }

    @Override
    public int getUserId() throws SQLException, ClassNotFoundException {
        int userId = 0;
        String query = null;
        Statement s = null;
        Connection con = new Connecting().getConnection();
        s = con.createStatement();
        query = "select max(userId)+1 from user";
        ResultSet rs = s.executeQuery(query);
        while(rs.next())
        {
            userId = rs.getInt(1);
            if(userId<=0)
            {
                userId = 1;
            }
        }
        s.close();
        con.close();

        return userId;
    }

    @Override
    public String getUserInfo(int userId) throws SQLException, ClassNotFoundException, Jukeboxexception {
        String passwd = null;

        String query = "select password from user where userid = ?";
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                passwd = rs.getString(1);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        return passwd;
    }
}
