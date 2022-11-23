package dao;
import Connection.*;

import JukeboxException.Jukeboxexception;
import entity.Playlist;

import java.sql.*;

public class Playlistdao implements PlaylistdaoInterface {

    @Override
    public void addPlaylist(Playlist p) throws SQLException, ClassNotFoundException, Jukeboxexception {
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "insert into playlist(playid,playlistName) values(?,?)";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,p.getPlaylistId());
            ps.setString(2,p.getPlaylistName());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new Jukeboxexception("Same Name Already Available in playlist");
        }
        ps.close();
        con.close();
    }

    @Override
    public int deletePlaylist(int playlistId) throws SQLException, ClassNotFoundException, Jukeboxexception {
        int count = 0;
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "delete from playlist where playid = ?";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,playlistId);
            count = ps.executeUpdate();

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        return count;
    }

    @Override
    public void retrievePlaylist(int userId) throws SQLException, ClassNotFoundException {
        System.out.format("%-20s %-20s", "Playlist ID", "Playlist Name");
        System.out.println();
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "select pl.playid,pl.playlistName from playlist pl,playuserrelation p where p.userid = ? and pl.playid=p.playid ";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int playlistId = rs.getInt(1);
                String playlistName = rs.getString(2);
                System.out.format("%-20s %-20s", playlistId,playlistName);
                System.out.println();
            }
        }
        catch(Exception e)
        {
            System.out.println("Information Mismatch");
        }
        ps.close();
        con.close();
    }

    @Override
    public int getPlaylistId() throws SQLException, ClassNotFoundException {
        int playlistId = 0;
        String query = "select max(playid)+1 from playlist";
        Connection con = new Connecting().getConnection();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(query);
        while(rs.next())
        {
            playlistId = rs.getInt(1);
            if(playlistId<=0)
            {
                playlistId = 1;
            }
        }
        s.close();
        con.close();

        return playlistId;
    }

    @Override
    public void playUserRelation(int userId, int playlistId) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "insert into playuserrelation(userid,playid) values(?,?)";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,userId);
            ps.setInt(2,playlistId);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();
    }
}
