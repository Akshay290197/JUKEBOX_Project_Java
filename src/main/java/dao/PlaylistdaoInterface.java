package dao;
import JukeboxException.Jukeboxexception;
import entity.*;

import java.sql.SQLException;

public interface PlaylistdaoInterface {

    public void addPlaylist(Playlist p) throws SQLException, ClassNotFoundException, Jukeboxexception;
    public int deletePlaylist(int playlistId) throws SQLException, ClassNotFoundException, Jukeboxexception;
    public void retrievePlaylist(int userId) throws SQLException, ClassNotFoundException;
    public int getPlaylistId() throws SQLException, ClassNotFoundException;
    public void playUserRelation(int userId,int playlistId) throws SQLException, ClassNotFoundException;

}
