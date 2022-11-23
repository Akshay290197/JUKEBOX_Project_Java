import OperationPackage.PodcastOperation;
import entity.Songs;
import entity.podcastList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPodcastOperation {

    PodcastOperation po;

    @BeforeEach
    public void setup()
    {
        po = new PodcastOperation();
    }

    @AfterEach
    public void tear()
    {
        po = null;
    }

    @Test
    public void checkPodcastListUsingPodcastNames() throws SQLException, ClassNotFoundException {
        List<podcastList> pod1,pod2;
        String name = "dil";
        String name1 = "kh";
        pod1 = po.getPodcastListUsingPodcastName(name);
        assertEquals(1,pod1.size());
        pod2 = po.getPodcastListUsingPodcastName(name1);
        assertEquals(5,pod2.get(0).getPodcastId());
    }

    @Test
    public void checkPodcastListusingCelebrityNames() throws SQLException, ClassNotFoundException {
        List<podcastList> pod1,pod2;
        String name = "jubin";
        String name1 = "arjit";
        pod1 = po.getPodcastListUsingCelebrityName(name);
        assertEquals(2,pod1.size());
        pod2 = po.getPodcastListUsingCelebrityName(name1);
        assertEquals(8,pod2.get(2).getPodcastId());
    }

    @Test
    public void checkPodcastListusingPodcastId() throws SQLException, ClassNotFoundException {
        List<podcastList> pod1,pod2;
        int id = 5;
        int id1 = 8;
        pod1 = po.getPodcastListUsingPodcastId(id);
        assertEquals("Khaab",pod1.get(0).getPodcastName());
        pod2 = po.getPodcastListUsingPodcastId(id1);
        assertEquals("Arjit singh",pod2.get(0).getCelebrityName());
    }

    @Test
    public void sortPodcastNames() throws SQLException, ClassNotFoundException {
        List<podcastList> pod1,pod2;
        pod1 = po.sortPodcastListByPodcastName();
        assertEquals(5,pod1.get(3).getPodcastId());
        pod2 = po.sortPodcastListByPodcastName();
        assertEquals("Arjit singh",pod2.get(7).getCelebrityName());
    }
}
