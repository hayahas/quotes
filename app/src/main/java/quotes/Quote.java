package quotes;

import java.util.ArrayList;

public class Quote {

    private ArrayList<String> tags;
    private String author;
    private String likes;
    private String text;


    public Quote(ArrayList<String> tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public String getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return ("Qoute : " + text + "\nAuthor : " + author );
    }
}
