package OperationPackage;

import JukeboxException.Jukeboxexception;
import dao.SongdaoInterface;
import dao.Songsdao;
import entity.Songs;

import java.sql.SQLException;
import java.util.List;

public class SongOperation {
    SongdaoInterface sdi = new Songsdao();

    public void displaySongList() throws SQLException, ClassNotFoundException {
        List<Songs> s ;

        System.out.format("%-10s %-30s %-20s %-20s %-20s %-20s","Song Id","Song Name","duration",
                "genre","Artist Name","Album Name");
        System.out.println("\n");

         s = sdi.displayAllSongs();

         for(Songs song : s)
         {
             System.out.println(song);
         }
    }

    public List<Songs> getSongListBySongName(String songName) throws SQLException, ClassNotFoundException, Jukeboxexception {
        List<Songs> s = null;
        try {
            s = sdi.songListByName(songName);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return s;
    }

    public List<Songs> getSongListByArtistName(String artistName) throws SQLException, ClassNotFoundException {
        List<Songs> s;
        s = sdi.songListByArtistName(artistName);
        return s;
    }

    public List<Songs> getSongListByAlbumName(String albumName) throws SQLException, ClassNotFoundException {
        List<Songs> s;
        s = sdi.songListByAlbum(albumName);
        return s;
    }

    public List<Songs> getSongListByGenre(String genre) throws SQLException, ClassNotFoundException {
        List<Songs> s;
        s = sdi.songListByGenre(genre);
        return s;
    }

    public List<String> displayAllAlbumNames() throws SQLException, ClassNotFoundException {
        List<String> s;
        s = sdi.albumNamesInSongList();
        return s;
    }

    public List<Songs> getSongListContainingSingleSongBySongId(int songId) throws SQLException, ClassNotFoundException {
        List<Songs> s;
        s = sdi.songListBySongId(songId);
        return s;
    }

    public List<Songs> sortSongListBySongName() throws SQLException, ClassNotFoundException {
        List<Songs> s;
        s = sdi.sortSongBySongName();
        return s;
    }
}
