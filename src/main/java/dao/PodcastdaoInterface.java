package dao;
import JukeboxException.Jukeboxexception;
import entity.*;

import java.sql.SQLException;
import java.util.List;

public interface PodcastdaoInterface {

    public void addPodcastInPlaylist(int playId,int songId) throws SQLException, ClassNotFoundException, Jukeboxexception;
    public void retrievePodcast(int playlistId) throws SQLException, ClassNotFoundException;
    public List<podcastList> displayAllPodcast() throws SQLException, ClassNotFoundException;
    public List<podcastList> podcastListUsingPodcastName(String podcastName) throws SQLException, ClassNotFoundException;
    public List<podcastList> podcastListUsingCelebrityName(String celebrityName) throws SQLException, ClassNotFoundException;
    public List<podcastList> podcastListUsingPublishDate(String publishDate) throws SQLException, ClassNotFoundException;
    public List<podcastList> podcastListUsingPodcastId(int podcastId) throws SQLException, ClassNotFoundException;
    public List<podcastList> sortPodcastListByPodcastNames() throws SQLException, ClassNotFoundException;


}
