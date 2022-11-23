package dao;

import java.sql.SQLException;

public interface AudiodaoInterface {

    public String retrieveSongURL(int songId) throws SQLException, ClassNotFoundException;
    public String retrievePodcastURL(int podcastId) throws SQLException, ClassNotFoundException;
}
