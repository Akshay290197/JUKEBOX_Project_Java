package dao;

import Connection.Connecting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Audiodao implements AudiodaoInterface {

    @Override
    public String retrieveSongURL(int songId) throws SQLException, ClassNotFoundException {
        String songurl = null;
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "select songurl from songs s where songid = ?";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,songId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                songurl = rs.getString(1);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        return songurl;
    }

    @Override
    public String retrievePodcastURL(int podcastId) throws SQLException, ClassNotFoundException {

        String podurl = null;
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "select podcasturl from podcast where podcasturl = ?";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,podcastId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                podurl = rs.getString(1);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        return podurl;
    }
}
