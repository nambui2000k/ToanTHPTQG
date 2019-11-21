package vn.poly.toanthptqg.model;

public class News {
    private String title,description,time,image,link;

    public News() {
    }

    public News(String title, String description, String time, String image, String link) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.image = image;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
