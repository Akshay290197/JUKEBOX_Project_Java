package App;

import JukeboxException.Jukeboxexception;
import com.sun.tools.javac.Main;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMethod {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedAudioFileException,
            IOException, LineUnavailableException, Jukeboxexception {
        Scanner sc = new Scanner(System.in);
        UserFunction u = new UserFunction();
        PlaylistFunction plf = new PlaylistFunction();
        SongFunction sf = new SongFunction();
        PodcastFunction pf = new PodcastFunction();
        Audio a = new Audio();

        System.out.println("Welcome to Jukebox");
        int n = 0;

            do {
                System.out.println("1.   For user");
                System.out.println("2.   For Playlist");
                System.out.println("3.   For Song");
                System.out.println("4.   For Podcast");
                System.out.println("5.   Play Song");
                System.out.println("6.   Play Podcast");
                System.out.println("7.   EXIT !!!");
                n = sc.nextInt();
                if(n<=0 || n > 7)
                {
                    System.out.println("Please Enter Between 1 - 7");
                }

                switch (n) {
                    case 1: {
                        try {
                            u.userFunc();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 2: {
                        try {
                            plf.playFunc();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 3: {
                        try {
                            sf.songFunc();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 4: {
                        try {
                            pf.podcastFunc();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 5: {
                        try {
                            a.playSong();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 6: {
                        try
                        {
                            a.playPodcast();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                }
            } while (n != 7);
    }
}
