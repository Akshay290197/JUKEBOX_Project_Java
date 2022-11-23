import JukeboxException.Jukeboxexception;
import OperationPackage.SongOperation;
import entity.Songs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSongOperation {

    SongOperation so;

    @BeforeEach
    public void setup()
    {
        so = new SongOperation();
    }

    @AfterEach
    public void tear()
    {
        so = null;
    }

    @Test
    public void checkSongByName() throws SQLException, ClassNotFoundException, Jukeboxexception {
        List<Songs> song,song1,song2;
        String name = "bi";
        String name1 = "leh";
        song = so.getSongListBySongName(name);
        assertEquals(2,song.size());
        song1 = so.getSongListBySongName(name1);
        assertEquals(1,song1.size());
        song2 = so.getSongListBySongName(name1);
        assertEquals("Lehanga",song2.get(0).getSongName());
    }

    @Test
    public void checksongByAlbumName() throws SQLException, ClassNotFoundException {
        List<Songs> song,song1;
        String name = "jubin";
        song = so.getSongListByAlbumName(name);
        assertEquals(3,song.size());
        song1 = so.getSongListByAlbumName(name);
        assertEquals(10,song1.get(2).getSongId());

    }

    @Test
    public void checksongByGenre() throws SQLException, ClassNotFoundException {
        List<Songs> song,song1 ;
        String genre = "bolly";
        song = so.getSongListByGenre(genre);
        assertEquals(4,song.size());
        song1 = so.getSongListByGenre(genre);
        assertEquals(3,song1.get(0).getSongId());
    }

    @Test
    public void displayAllAlbumNames() throws SQLException, ClassNotFoundException {
        List<String> song,song1;
        song = so.displayAllAlbumNames();
        assertEquals(10,song.size());
        song1 = so.displayAllAlbumNames();
        assertEquals("Lehanga",song1.get(8));
    }

    @Test
    public void sortSongName() throws SQLException, ClassNotFoundException {
        List<Songs> song,song1;
        song = so.sortSongListBySongName();
        assertEquals(2,song.get(3).getSongId());
        song1 = so.sortSongListBySongName();
        assertEquals("high-rated-gabru",song1.get(5).getSongName());
    }

}
