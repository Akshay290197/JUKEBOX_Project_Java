package App;

import JukeboxException.Jukeboxexception;
import OperationPackage.SongOperation;
import dao.*;
import Audio.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Audio {
    Scanner sc = new Scanner(System.in);

    PlaylistdaoInterface pdi = new Playlistdao();
    UserdaoInterface udi = new Userdao();
    SongdaoInterface sdi = new Songsdao();
    SongOperation so = new SongOperation();
    AudioPlayer ap = new AudioPlayer();
    PodcastdaoInterface podcain = new Podcastdao();

    public void playSong() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException, Jukeboxexception {
        System.out.println("Enter user id");
        int uid = sc.nextInt();
        System.out.println("Enter your password");
        String pwd = sc.next();
        String pass = udi.getUserInfo(uid);

        if (pass.equals(pwd)) {
            pdi.retrievePlaylist(uid);
            System.out.println("select the playlist by playlist Id");
            int playlistId = sc.nextInt();
            sdi.retrieveSongs(playlistId);
            int no;
            do {
                System.out.println("Select the song ID which you want to play");
                int sid = sc.nextInt();
                ap.playSong(sid);

                System.out.println("PRESS 1 FOR CONTINUE  ||  PRESS 2 FOR EXIT!!");
                no = sc.nextInt();
            }while(no!=2);
        }
        else
        {
            System.out.println("wrong password");
        }
    }

    public void playPodcast() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException, Jukeboxexception {
        System.out.println("Enter user id");
        int uid = sc.nextInt();
        System.out.println("Enter your password");
        String pwd = sc.next();
        String pass = udi.getUserInfo(uid);

        if (pass.equals(pwd)) {
            pdi.retrievePlaylist(uid);
            System.out.println("select the playlist by playlist Id");
            int playlistId = sc.nextInt();
            podcain.retrievePodcast(playlistId);
            int no;
            do {
                System.out.println("Select the Podcast ID which you want to play");
                int sid = sc.nextInt();
                ap.playPodcast(sid);

                System.out.println("PRESS 1 FOR CONTINUE  ||  PRESS 2 FOR EXIT!!");
                no = sc.nextInt();
            }while(no!=2);
        }
        else
        {
            System.out.println("wrong password");
        }
    }
}
