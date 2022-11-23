package App;
import JukeboxException.Jukeboxexception;
import OperationPackage.PodcastOperation;
import dao.*;
import entity.podcastList;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PodcastFunction {

    Scanner sc = new Scanner(System.in);
    PlaylistdaoInterface pdi = new Playlistdao();
    UserdaoInterface udi = new Userdao();
    PodcastdaoInterface podcain = new Podcastdao();
    PodcastOperation po = new PodcastOperation();

    public void podcastFunc() throws SQLException, ClassNotFoundException, Jukeboxexception {
        System.out.println("Enter user id");
        int uid = sc.nextInt();
        System.out.println("Enter your password");
        String pwd = sc.next();
        String pass = udi.getUserInfo(uid);

        if (pass.equals(pwd)) {
            int n, no;
            do {
                System.out.println("1.      Add Podcast in playlist");
                System.out.println("2.      Check Podcast in playlist");
                System.out.println("3.      Display Podcast List");
                System.out.println("4.      Check Podcast Using Podcast Name");
                System.out.println("5.      Check Podcast Using Celebrity Name");
                System.out.println("6.      Check Podcast By Publish Date");
                System.out.println("7.      Check Podcast Using Podcast ID");
                System.out.println("8.      Sort Podcast By Podcast Name");
                System.out.println("9.      EXIT");
                n = sc.nextInt();

                switch (n) {
                    case 1: {
                            pdi.retrievePlaylist(uid);
                            System.out.println("select the playlist by playlist Id");
                            int playlistId = sc.nextInt();
                             po.displayPodcastList();
                            do {
                                System.out.println("Enter the podcast Id to add in playlist");
                                int pid = sc.nextInt();
                                podcain.addPodcastInPlaylist(playlistId, pid);
                                System.out.println("Podcast Added Successfully ");

                                System.out.println("Press 1 For EXIT & 2 For Continue !!!!! ");
                                no = sc.nextInt();

                            } while (no != 1);
                        break;
                    }
                    case 2: {

                            pdi.retrievePlaylist(uid);
                            System.out.println("select the playlist by playlist Id");
                            int playlistId = sc.nextInt();
                            podcain.retrievePodcast(playlistId);
                            break;
                    }
                    case 3:
                    {
                        po.displayPodcastList();
                        break;
                    }
                    case 4: {
                        List<podcastList> pod ;
                        System.out.println();
                        System.out.println("Enter Podcast Name \n");
                        String pName = sc.next();
                        pod = po.getPodcastListUsingPodcastName(pName);

                        System.out.format("%-20s %-40s %-30s %-20s ","Podcast Id","Podcast Name","Celebrity Name",
                                "Publish Date");
                        System.out.println("\n");

                        for(podcastList p :pod)
                        {
                            System.out.println(p);
                        }
                        break;
                    }
                    case 5: {
                        List<podcastList> pod ;
                        System.out.println();
                        System.out.println("Enter Celebrity Name \n");
                        String celeName = sc.next();
                        pod = po.getPodcastListUsingCelebrityName(celeName);

                        System.out.format("%-20s %-40s %-30s %-20s ","Podcast Id","Podcast Name","Celebrity Name",
                                "Publish Date");
                        System.out.println("\n");
                        for(podcastList p :pod)
                        {
                            System.out.println(p);
                        }
                        break;
                    }
                    case 6: {
                        List<podcastList> pod ;
                        System.out.println();
                        System.out.println("Enter Publish Date (YYYY-MM-DD) \n");
                        String pubDate = sc.next();
                        pod = po.getPodcastListUsingPublishDate(pubDate);

                        System.out.format("%-20s %-40s %-30s %-20s ","Podcast Id","Podcast Name","Celebrity Name",
                                "Publish Date");
                        System.out.println("\n");
                        for(podcastList p :pod)
                        {
                            System.out.println(p);
                        }
                        break;
                    }
                    case 7: {
                        List<podcastList> pod ;
                        System.out.println();
                        System.out.println("Enter Podcast ID \n");
                        int podId = sc.nextInt();
                        pod = po.getPodcastListUsingPodcastId(podId);

                        System.out.format("%-20s %-40s %-30s %-20s","Podcast Id","Podcast Name","Celebrity Name",
                                "Publish Date");
                        System.out.println("\n");
                        for(podcastList p :pod)
                        {
                            System.out.println(p);
                        }
                        break;
                    }
                    case 8: {
                        List<podcastList> pod ;
                        pod = po.sortPodcastListByPodcastName();

                        System.out.format("%-20s %-40s %-30s %-20s","Podcast Id","Podcast Name","Celebrity Name",
                                "Publish Date");
                        System.out.println("\n");
                        for(podcastList p :pod)
                        {
                            System.out.println(p);
                        }
                        break;
                    }
                }
            } while (n != 9);
        }
        else
        {
            System.out.println("Entry Mismatch");
        }
    }
}
