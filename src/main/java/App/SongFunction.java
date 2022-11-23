package App;

import JukeboxException.Jukeboxexception;
import OperationPackage.SongOperation;
import dao.*;
import entity.Songs;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SongFunction {
    Scanner sc = new Scanner(System.in);
    PlaylistdaoInterface pdi = new Playlistdao();
    UserdaoInterface udi = new Userdao();
    SongdaoInterface sdi = new Songsdao();
    SongOperation so = new SongOperation();

    public void songFunc() throws SQLException, ClassNotFoundException, Jukeboxexception {
        System.out.println("Enter user id");
        int uid = sc.nextInt();
        System.out.println("Enter your password");
        String pwd = sc.next();
        String pass = udi.getUserInfo(uid);

        if (pass.equals(pwd)) {
            int n, no;
            do {
                System.out.println();
                System.out.println("1.      Add Song in playlist");
                System.out.println("2.      Check Song in playlist");
                System.out.println("3.      Check All Songs List");
                System.out.println("4.      Check Song List By Song Name");
                System.out.println("5.      Check Song List By Arist Name");
                System.out.println("6.      Check Song List By Album Name");
                System.out.println("7.      Check Song List By Genre");
                System.out.println("8.      Check All Album Names");
                System.out.println("9.      Check Song By Song ID");
                System.out.println("10.     Check Song List In Sorting Order By Song Names(Alphabetical Ascending Order) ");
                System.out.println("11.      EXIT");
                n = sc.nextInt();

                switch (n) {
                    case 1: {
                        pdi.retrievePlaylist(uid);
                        System.out.println("select the playlist by playlist Id");
                        int playlistId = sc.nextInt();
                        so.displaySongList();
                        do {
                            System.out.println("Enter the song Id to add in playlist");
                            int sid = sc.nextInt();
                            sdi.addSongInPlaylist(playlistId, sid);
                            System.out.println("Song added successfully");

                            System.out.println("Press 1 For EXIT & 2 For Continue !!!!! ");
                            no = sc.nextInt();

                        } while (no != 1);
                        break;
                    }

                    case 2: {

                        pdi.retrievePlaylist(uid);
                        System.out.println("select the playlist by playlist Id");
                        int playlistId = sc.nextInt();
                        sdi.retrieveSongs(playlistId);
                        break;
                    }
                    case 3: {
                        so.displaySongList();
                        break;
                    }
                    case 4: {
                        List<Songs> s;
                        System.out.println();
                        System.out.println("Enter Song Name");
                        String sName = sc.next();
                        s = so.getSongListBySongName(sName);

                            System.out.format("%-10s %-30s %-20s %-20s %-20s %-20s", "Song Id", "Song Name", "duration",
                                    "genre", "Artist Name", "Album Name");
                            System.out.println();
                            for (Songs song : s) {
                                System.out.println(song);
                            }
                        break;
                    }
                    case 5: {
                        List<Songs> s;
                        System.out.println();
                        System.out.println("Enter Artist Name");
                        String artistName = sc.next();
                        s =  so.getSongListByArtistName(artistName);

                        System.out.format("%-10s %-30s %-20s %-20s %-20s %-20s","Song Id","Song Name","duration",
                                "genre","Artist Name","Album Name");
                        System.out.println();
                        for(Songs song : s)
                        {
                            System.out.println(song);
                        }
                        break;
                    }
                    case 6: {
                        List<Songs> s;
                        System.out.println();
                        System.out.println("Enter Album Name");
                        String albumName = sc.next();
                        s = so.getSongListByAlbumName(albumName);

                        System.out.format("%-10s %-30s %-20s %-20s %-20s %-20s","Song Id","Song Name","duration",
                                "genre","Artist Name","Album Name");
                        System.out.println();
                        for(Songs song : s)
                        {
                            System.out.println(song);
                        }
                        break;
                    }
                    case 7: {
                        List<Songs> s;
                        System.out.println();
                        System.out.println("Enter Genre");
                        String genre = sc.next();
                        s = so.getSongListByGenre(genre);

                        System.out.format("%-10s %-30s %-20s %-20s %-20s %-20s","Song Id","Song Name","duration",
                                "genre","Artist Name","Album Name");
                        System.out.println();
                        for(Songs song : s)
                        {
                            System.out.println(song);
                        }
                        break;
                    }
                    case 8:
                    {
                        List<String> s;
                        s = so.displayAllAlbumNames();

                        System.out.format("%-10s","ALBUM NAME");
                        System.out.println();
                        for(String song : s)
                        {
                            System.out.format("%-10s",song);
                            System.out.println();
                        }
                        break;
                    }

                    case 9: {
                        List<Songs> s;
                        System.out.println();
                        System.out.println("Enter Song ID");
                        int songId = sc.nextInt();
                        s = so.getSongListContainingSingleSongBySongId(songId);

                        System.out.format("%-10s %-30s %-20s %-20s %-20s %-20s","Song Id","Song Name","duration",
                                "genre","Artist Name","Album Name");
                        System.out.println();
                        for(Songs song : s)
                        {
                            System.out.println(song);
                        }
                        break;
                    }
                    case 10: {
                        List<Songs> s;
                        s = so.sortSongListBySongName();

                        System.out.format("%-10s %-30s %-20s %-20s %-20s %-20s","Song Id","Song Name","duration",
                                "genre","Artist Name","Album Name");
                        System.out.println();
                        for(Songs song : s)
                        {
                            System.out.println(song);
                        }
                        break;
                    }
                }
            } while (n != 11);
        }
        else
        {
            System.out.println("Entry Mismatch");
        }
    }
}

