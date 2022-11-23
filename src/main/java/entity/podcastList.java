package entity;

public class podcastList {

    int podcastId;
    String podcastName;
    String celebrityName;
    String publishDate;

    public podcastList(int podcastId, String podcastName, String celebrityName, String publishDate) {
        this.podcastId = podcastId;
        this.podcastName = podcastName;
        this.celebrityName = celebrityName;
        this.publishDate = publishDate;
    }

    public int getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(int podcastId) {
        this.podcastId = podcastId;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getCelebrityName() {
        return celebrityName;
    }

    public void setCelebrityName(String celebrityName) {
        this.celebrityName = celebrityName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        System.out.format("%-20s %-40s %-30s %-20s ",podcastId,podcastName,celebrityName,publishDate);
        System.out.println();
        return "";
    }
}
