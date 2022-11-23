package dao;
import JukeboxException.Jukeboxexception;
import entity.*;

import java.sql.SQLException;
import java.util.List;

public interface SongdaoInterface {

    public void addSongInPlaylist(int playId,int songId) throws SQLException, ClassNotFoundException, Jukeboxexception;
    public void retrieveSongs(int playId) throws SQLException, ClassNotFoundException;
    public List<Songs> displayAllSongs() throws SQLException, ClassNotFoundException;
    public List<Songs> songListByName(String songName) throws SQLException, ClassNotFoundException, Jukeboxexception;
    public List<Songs> songListByArtistName(String artistName) throws SQLException, ClassNotFoundException;
    public List<Songs> songListByAlbum(String albumName) throws SQLException, ClassNotFoundException;
    public List<Songs> songListByGenre(String genre) throws SQLException, ClassNotFoundException;
    public List<String> albumNamesInSongList() throws SQLException, ClassNotFoundException;
    public List<Songs> songListBySongId(int songId) throws SQLException, ClassNotFoundException;
    public List<Songs> sortSongBySongName() throws SQLException, ClassNotFoundException;

}
