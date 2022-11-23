package OperationPackage;

import dao.Podcastdao;
import dao.PodcastdaoInterface;
import entity.podcastList;

import java.sql.SQLException;
import java.util.List;

public class PodcastOperation {
    PodcastdaoInterface pdi = new Podcastdao();

    public void displayPodcastList() throws SQLException, ClassNotFoundException {
        List<podcastList> pod ;
        System.out.format("%-20s %-40s %-30s %-20s","Podcast Id","Podcast Name","Celebrity Name",
                "Publish Date");
        System.out.println("\n");
        pod = pdi.displayAllPodcast();

        for(podcastList p :pod)
        {
            System.out.println(p);
        }
    }

    public List<podcastList> getPodcastListUsingPodcastName(String podcastName) throws SQLException, ClassNotFoundException {
        List<podcastList> pod ;
        pod = pdi.podcastListUsingPodcastName(podcastName);
        return pod;
    }

    public List<podcastList> getPodcastListUsingCelebrityName(String celebrityName) throws SQLException, ClassNotFoundException {
        List<podcastList> pod ;
        pod = pdi.podcastListUsingCelebrityName(celebrityName);
        return pod;
    }

    public List<podcastList> getPodcastListUsingPublishDate(String publishDate) throws SQLException, ClassNotFoundException {
        List<podcastList> pod ;
        pod = pdi.podcastListUsingPublishDate(publishDate);
        return pod;
    }

    public List<podcastList> getPodcastListUsingPodcastId(int podcastId) throws SQLException, ClassNotFoundException {
        List<podcastList> pod ;
        pod = pdi.podcastListUsingPodcastId(podcastId);
        return pod;
    }

    public List<podcastList> sortPodcastListByPodcastName() throws SQLException, ClassNotFoundException {
        List<podcastList> pod ;
        pod = pdi.sortPodcastListByPodcastNames();
        return pod;
    }
}
