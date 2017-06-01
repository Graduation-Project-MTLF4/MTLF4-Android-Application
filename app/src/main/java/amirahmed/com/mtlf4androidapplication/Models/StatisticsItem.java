package amirahmed.com.mtlf4androidapplication.Models;


public class StatisticsItem {

    public String title;
    public String date;
    public String likes;
    public String views;
    public String favorites;
    public String comments;


    public StatisticsItem(String title, String date, String likes, String views, String favorites, String comments) {
        this.title = title;
        this.date = date;
        this.likes = likes;
        this.views = views;
        this.favorites = favorites;
        this.comments = comments;
    }
}
