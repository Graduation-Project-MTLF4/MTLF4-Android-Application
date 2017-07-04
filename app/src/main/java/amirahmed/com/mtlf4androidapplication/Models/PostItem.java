package amirahmed.com.mtlf4androidapplication.Models;


public class PostItem {

    public String name;
    public String details;
    public int photoId;
    public Boolean fav;
    public Boolean like;
    public String viewsnumber;


    public void setFav(Boolean fav) {
        this.fav = fav;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public PostItem(String name, String details, int photoId,String viewsnumber, Boolean fav, Boolean like) {
        this.name = name;
        this.details = details;
        this.photoId = photoId;
        this.viewsnumber = viewsnumber;
        this.fav = fav;
        this.like = like;
    }
}
