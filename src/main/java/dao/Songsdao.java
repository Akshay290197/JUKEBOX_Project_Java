package dao;
import Connection.*;

import JukeboxException.Jukeboxexception;
import entity.Songs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Songsdao implements SongdaoInterface {

    @Override
    public void addSongInPlaylist(int playId,int songid) throws SQLException, ClassNotFoundException, Jukeboxexception {
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "insert into playsong(playId,songid) values(?,?) ";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,playId);
            ps.setInt(2,songid);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();
    }

    @Override
    public void retrieveSongs(int playId) throws SQLException, ClassNotFoundException {
        int songid = 0;
        System.out.format("%-30s %-30s %-30s","Song ID","Song Name","Song duration");
        System.out.println();
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "select s.songid,s.songName,s.songduration from songs s,playsong p where p.playid = ? and p.songid = s.songid";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,playId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                songid = rs.getInt(1);
                String sname = rs.getString(2);
                String sdur = rs.getString(3);
                System.out.format("%-30s %-30s %-30s",songid,sname,sdur);
                System.out.println();
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();
    }

    @Override
    public List<Songs> displayAllSongs() throws SQLException, ClassNotFoundException {

        List<Songs> song = new ArrayList<>();
        Statement s = null;
        Connection con = new Connecting().getConnection();
        String query = "select songid,songname,songduration,genre,Artistname,AlbumName from songs";
        s=con.createStatement();
        ResultSet rs = s.executeQuery(query);
        while(rs.next()) {
            int songId = rs.getInt(1);
            String songName = rs.getString(2);
            String duration = rs.getString(3);
            String genre = rs.getString(4);
            String artistName = rs.getString(5);
            String albumName = rs.getString(6);
            Songs so = new Songs(songId,songName,duration,genre,artistName,albumName);
            song.add(so);
        }
        s.close();
        con.close();

        return song;
    }

    @Override
    public List<Songs> songListByName(String songName) throws SQLException, ClassNotFoundException, Jukeboxexception {

        int songId = 0;
        List<Songs> song = new ArrayList<>();
        PreparedStatement ps =null;
        Connection con = new Connecting().getConnection();
        String query = "select songid,songname,songduration,genre,Artistname,AlbumName from songs where songname like concat( ?,'%')";
        try{
            ps = con.prepareStatement(query);
            ps.setString(1,songName);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                songId = rs.getInt(1);
                String sName = rs.getString(2);
                String duration = rs.getString(3);
                String genre = rs.getString(4);
                String artistName = rs.getString(5);
                String albumName = rs.getString(6);
                Songs so = new Songs(songId,sName,duration,genre,artistName,albumName);
                song.add(so);
            }

            if(songId == 0)
            {
                System.out.println("No Matching details found \n");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        return song;
    }

    @Override
    public List<Songs> songListByArtistName(String artistName) throws SQLException, ClassNotFoundException {
        int songId = 0;
        List<Songs> song = new ArrayList<>();
        PreparedStatement ps =null;
        Connection con = new Connecting().getConnection();
        String query = "select songid,songname,songduration,genre,Artistname,AlbumName from songs where artistname like concat( ?,'%')";
        try{
            ps = con.prepareStatement(query);
            ps.setString(1,artistName);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                songId = rs.getInt(1);
                String sName = rs.getString(2);
                String duration = rs.getString(3);
                String genre = rs.getString(4);
                String aName = rs.getString(5);
                String albumName = rs.getString(6);
                Songs so = new Songs(songId,sName,duration,genre,aName,albumName);
                song.add(so);
            }

            if(songId == 0)
            {
                System.out.println("No Matching details found \n");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        return song;
    }

    @Override
    public List<Songs> songListByAlbum(String albumName) throws SQLException, ClassNotFoundException {
        int songId = 0;
        List<Songs> song = new ArrayList<>();
        PreparedStatement ps =null;
        Connection con = new Connecting().getConnection();
        String query = "select songid,songname,songduration,genre,Artistname,AlbumName from songs where albumname like concat( ?,'%')";
        try{
            ps = con.prepareStatement(query);
            ps.setString(1,albumName);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                songId = rs.getInt(1);
                String sName = rs.getString(2);
                String duration = rs.getString(3);
                String genre = rs.getString(4);
                String aName = rs.getString(5);
                String albName = rs.getString(6);
                Songs so = new Songs(songId,sName,duration,genre,aName,albName);
                song.add(so);
            }
            if(songId == 0)
            {
                System.out.println("No Matching details found \n");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        return song;
    }

    @Override
    public List<Songs> songListByGenre(String genre) throws SQLException, ClassNotFoundException {
        int songId = 0;
        List<Songs> song = new ArrayList<>();
        PreparedStatement ps =null;
        Connection con = new Connecting().getConnection();
        String query = "select songid,songname,songduration,genre,Artistname,AlbumName from songs where genre like concat( ?,'%')";
        try{
            ps = con.prepareStatement(query);
            ps.setString(1,genre);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                songId = rs.getInt(1);
                String sName = rs.getString(2);
                String duration = rs.getString(3);
                String gen = rs.getString(4);
                String aName = rs.getString(5);
                String albName = rs.getString(6);
                Songs so = new Songs(songId,sName,duration,gen,aName,albName);
                song.add(so);
            }
            if(songId == 0)
            {
                System.out.println("No Matching details found \n");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        return song;
    }

    @Override
    public List<String> albumNamesInSongList() throws SQLException, ClassNotFoundException {
        List<String> song = new ArrayList<>();
        Statement st = null;
        Connection con = new Connecting().getConnection();
        String query = "select albumname from songs";
        try{
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                String albumName = rs.getString(1);
                song.add(albumName);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        st.close();
        con.close();

        return song;
    }

    @Override
    public List<Songs> songListBySongId(int songId) throws SQLException, ClassNotFoundException {
        int songid = 0;
        List<Songs> song = new ArrayList<>();
        PreparedStatement ps =null;
        Connection con = new Connecting().getConnection();
        String query = "select songid,songname,songduration,genre,Artistname,AlbumName from songs where songid = ?";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,songId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                songid = rs.getInt(1);
                String sName = rs.getString(2);
                String duration = rs.getString(3);
                String gen = rs.getString(4);
                String aName = rs.getString(5);
                String albName = rs.getString(6);
                Songs so = new Songs(songid,sName,duration,gen,aName,albName);
                song.add(so);
            }
            if(songid == 0)
            {
                System.out.println("Song id not match with existing song list \n");
            }
        }
        catch(Exception e)
        {
            System.out.println("Entry Mismatch !!!! ");
        }
        ps.close();
        con.close();

        return song;
    }

    @Override
    public List<Songs> sortSongBySongName() throws SQLException, ClassNotFoundException {

        List<Songs> song = new ArrayList<>();
        Statement st = null;
        Connection con = new Connecting().getConnection();
        String query = "select songid,songname,songduration,genre,Artistname,AlbumName from songs order by songname asc";
        try{
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                int songid = rs.getInt(1);
                String sName = rs.getString(2);
                String duration = rs.getString(3);
                String gen = rs.getString(4);
                String aName = rs.getString(5);
                String albName = rs.getString(6);
                Songs so = new Songs(songid,sName,duration,gen,aName,albName);
                song.add(so);
            }
        }
        catch(Exception e)
        {
            System.out.println("Entry Mismatch !!!! ");
        }
        st.close();
        con.close();

        return song;
    }


}
