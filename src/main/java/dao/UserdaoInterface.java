package dao;
import JukeboxException.Jukeboxexception;
import entity.*;

import java.sql.SQLException;

public interface UserdaoInterface {

    public void addUser(User u) throws SQLException, ClassNotFoundException, Jukeboxexception;
    public void deleteUser(int userId,String password) throws SQLException, ClassNotFoundException, Jukeboxexception;
    public void updateUserName(int userId,String password,String userName) throws SQLException, ClassNotFoundException, Jukeboxexception;
    public void updateUserPassword(int userId,String password,String userName) throws SQLException, ClassNotFoundException, Jukeboxexception;
    public void retrieveUser(int userId,String password) throws SQLException, ClassNotFoundException, Jukeboxexception;
    public int getUserId() throws SQLException, ClassNotFoundException;
    public String getUserInfo(int userId) throws SQLException, ClassNotFoundException, Jukeboxexception;

}
