package entity;

public class Songs {
    int songId;
    String songName;
    String songDuration;
    String genre;
    String artistName;
    String albumName;

    public Songs(int songId, String songName, String songDuration, String genre, String artistName, String albumName) {
        this.songId = songId;
        this.songName = songName;
        this.songDuration = songDuration;
        this.genre = genre;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public String toString() {
        System.out.format("%-10s %-30s %-20s %-20s %-20s %-20s",songId,songName,songDuration,
                genre,artistName,albumName);
        return "";
    }
}
