package Audio;
import dao.*;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class AudioPlayer {
    Scanner sc = new Scanner(System.in);

    AudiodaoInterface adi = new Audiodao();

    public void playSong(int songId) throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        String getUrl = adi.retrieveSongURL(songId);

        File file = new File(getUrl);
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(ais);

        String option = "";

        while(!option.equalsIgnoreCase("Q"))
        {
            System.out.println("P  =  Play,  R = Reset, S = Stop, Q = Quit ");
            option = sc.next();

            switch (option)
            {
                case "p":
                {
                    clip.start();
                    System.out.println();
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println("     >>>>>>><<<<<<<  N O W    P L A Y I N G  >>>>><<<<<<<   ");
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println();
                    break;
                }
                case "r":
                {
                    clip.setMicrosecondPosition(0);
                    break;
                }
                case "s":
                {
                    clip.stop();
                }
            }
        }
    }

    public void playPodcast(int podcastID) throws SQLException, UnsupportedAudioFileException, IOException, LineUnavailableException, ClassNotFoundException {
        String getUrl = adi.retrievePodcastURL(podcastID);

        File file = new File(getUrl);
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(ais);

        String option = "";

        while(!option.equalsIgnoreCase("Q"))
        {
            System.out.println("P  =  Play,  R = Reset, S = Stop, Q = Quit ");
            option = sc.next();

            switch (option)
            {
                case "p":
                {
                    clip.start();
                    break;
                }
                case "r":
                {
                    clip.setMicrosecondPosition(0);
                    break;
                }
                case "s":
                {
                    clip.stop();
                }
            }
        }
    }
}
