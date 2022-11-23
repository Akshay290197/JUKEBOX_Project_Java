package dao;
import Connection.*;
import JukeboxException.Jukeboxexception;
import entity.podcastList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Podcastdao implements PodcastdaoInterface {

    @Override
    public void addPodcastInPlaylist(int playId, int podId) throws SQLException, ClassNotFoundException, Jukeboxexception {
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "insert into playpod(playId,podid) values(?,?) ";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,playId);
            ps.setInt(2,podId);
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
    public void retrievePodcast(int playId) throws SQLException, ClassNotFoundException {
        int podid = 0;
        System.out.format("%-30s %-30s","podid","Podcast Name");
        System.out.println();
        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "select p.podid,p.podcastname from podcast p,playpod po where po.playid = ? and p.podid = po.podid";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,playId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                podid = rs.getInt(1);
                String sname = rs.getString(2);
                System.out.format("%-30s %-30s",podid,sname);
                System.out.println();
            }
            if(podid == 0)
            {
                System.out.println("Wrong Id selected");
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
    public List<podcastList> displayAllPodcast() throws SQLException, ClassNotFoundException {
        List<podcastList> pclist = new ArrayList<>();


        Statement s = null;
        Connection con = new Connecting().getConnection();
        String query = "select podid,podcastname,celebrityname,publishdate from podcast";
        s=con.createStatement();
        ResultSet rs = s.executeQuery(query);
        while(rs.next())
        {
            int podId = rs.getInt(1);
            String podcastName = rs.getString(2);
            String celebrityName = rs.getString(3);
            String publishdate = rs.getString(4);
            podcastList pcl = new podcastList(podId,podcastName,celebrityName,publishdate);
            pclist.add(pcl);
        }
        s.close();
        con.close();

        //return List
        return pclist;
    }

    @Override
    public List<podcastList> podcastListUsingPodcastName(String podcastName) throws SQLException, ClassNotFoundException {
        int pid = 0;
        List<podcastList> podcast = new ArrayList<>();

        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "select podid,podcastname,celebrityname,publishdate from podcast where podcastname like concat(?,'%') ";
        try{
            ps= con.prepareStatement(query);
            ps.setString(1,podcastName);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                pid = rs.getInt(1);
                String podname = rs.getString(2);
                String celeName = rs.getString(3);
                String publidate = rs.getString(4);
                podcastList pcl = new podcastList(pid,podname,celeName,publidate);
                podcast.add(pcl);
            }
            if(pid == 0)
            {
                System.out.println("Wrong Id selected");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        //return List
        return podcast;
    }

    @Override
    public List<podcastList> podcastListUsingCelebrityName(String celebrityName) throws SQLException, ClassNotFoundException {
        int pid = 0;
        List<podcastList> podcast = new ArrayList<>();

        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "select podid,podcastname,celebrityname,publishdate from podcast where celebrityname like concat(?,'%') ";
        try{
            ps= con.prepareStatement(query);
            ps.setString(1,celebrityName);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                pid = rs.getInt(1);
                String podname = rs.getString(2);
                String celeName = rs.getString(3);
                String publidate = rs.getString(4);
                podcastList pcl = new podcastList(pid,podname,celeName,publidate);
                podcast.add(pcl);
            }
            if(pid == 0)
            {
                System.out.println("Wrong Id selected");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        //return List
        return podcast;
    }

    @Override
    public List<podcastList> podcastListUsingPublishDate(String publishDate) throws SQLException, ClassNotFoundException {
        int pid = 0;
        List<podcastList> podcast = new ArrayList<>();

        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "select podid,podcastname,celebrityname,publishdate from podcast where publishdate = ? ";
        try{
            ps= con.prepareStatement(query);
            ps.setString(1,publishDate);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                pid = rs.getInt(1);
                String podname = rs.getString(2);
                String celeName = rs.getString(3);
                String publidate = rs.getString(4);
                podcastList pcl = new podcastList(pid,podname,celeName,publidate);
                podcast.add(pcl);
            }
            if(pid == 0)
            {
                System.out.println("Wrong Id selected");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        //return List
        return podcast;
    }

    @Override
    public List<podcastList> podcastListUsingPodcastId(int podcastId) throws SQLException, ClassNotFoundException {
        int pid = 0;
        List<podcastList> podcast = new ArrayList<>();

        PreparedStatement ps = null;
        Connection con = new Connecting().getConnection();
        String query = "select podid,podcastname,celebrityname,publishdate from podcast where podid = ? ";
        try{
            ps= con.prepareStatement(query);
            ps.setInt(1,podcastId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                pid = rs.getInt(1);
                String podname = rs.getString(2);
                String celeName = rs.getString(3);
                String publidate = rs.getString(4);
                podcastList pcl = new podcastList(pid,podname,celeName,publidate);
                podcast.add(pcl);
            }
            if(pid == 0)
            {
                System.out.println("Wrong Id selected");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        ps.close();
        con.close();

        //return List
        return podcast;
    }

    @Override
    public List<podcastList> sortPodcastListByPodcastNames() throws SQLException, ClassNotFoundException {
        List<podcastList> podcast = new ArrayList<>();

        Statement s = null;
        Connection con = new Connecting().getConnection();
        String query = "select podid,podcastname,celebrityname,publishdate from podcast order by podcastname ";
        try{
            s= con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next())
            {
                int pid = rs.getInt(1);
                String podname = rs.getString(2);
                String celeName = rs.getString(3);
                String publidate = rs.getString(4);
                podcastList pcl = new podcastList(pid,podname,celeName,publidate);
                podcast.add(pcl);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        s.close();
        con.close();

        //return List
        return podcast;
    }

}

