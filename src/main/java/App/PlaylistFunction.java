package App;
import java.sql.SQLException;
import java.util.Scanner;

import JukeboxException.Jukeboxexception;
import dao.*;
import entity.Playlist;

public class PlaylistFunction {
    Scanner sc = new Scanner(System.in);
    PlaylistdaoInterface pdi = new Playlistdao();
    UserdaoInterface udi = new Userdao();

    public void playFunc() throws SQLException, ClassNotFoundException, Jukeboxexception {
        System.out.println("Enter user id");
        int uid = sc.nextInt();
        System.out.println("Enter your password");
        String pwd = sc.next();
        String pass = udi.getUserInfo(uid);

        if (pass.equals(pwd)) {
            int n;
            do {
                System.out.println("1.      Create Playlist");
                System.out.println("2.      Delete Playlist");
                System.out.println("3.      Check Playlist");
                System.out.println("4.      Exit");
                n = sc.nextInt();

                switch (n) {
                    case 1: {

                            System.out.println("Enter your new playlist Name");
                            String name = sc.next();
                            int playlistId = pdi.getPlaylistId();
                            Playlist p = new Playlist(playlistId, name);
                            try {
                                pdi.addPlaylist(p);
                                pdi.playUserRelation(uid, playlistId);
                                System.out.println("Playlist Created !!");
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                        break;
                    }
                    case 2: {
                            pdi.retrievePlaylist(uid);
                            System.out.println();
                            System.out.println("Which playlist you want to delete (Select playlistId) :");
                            int playlistId = sc.nextInt();
                            try {
                                int i = pdi.deletePlaylist(playlistId);
                                if(i==1){
                                    System.out.println("Playlist Deleted !!");}
                                else{
                                    System.out.println("Playlist not deleted, please try again !!");
                                }
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                        break;
                    }
                    case 3: {
                            pdi.retrievePlaylist(uid);
                        break;
                    }
                }

            } while (n != 4);
        }
        else
        {
            System.out.println("password not match");
        }
    }
}
