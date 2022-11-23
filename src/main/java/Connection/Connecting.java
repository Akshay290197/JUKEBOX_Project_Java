package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecting {
    Connection con = null;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jukebox";
        String user = "root";
        String password = "akshay123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        con= DriverManager.getConnection(url,user,password);

        return con;
    }
}
