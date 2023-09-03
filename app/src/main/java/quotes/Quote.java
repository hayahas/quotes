package quotes;

import java.util.ArrayList;

public class Quote {

    private ArrayList<String> tags;
    private String author;
    private String likes;
    private String text;
    private int id;
    private boolean isDialogue;
    private boolean isPrivate;
    private String url;
    private int favCnt;
    private int upCnt;
    private int downCnt;

    private  String authorPermLink;
    private String body;

    public Quote() {
    }

    public Quote( String author, String likes, String text) {

        this.author = author;
        this.likes = likes;
        this.text = text;
    }
    public Quote(int id, boolean isDialogue,  boolean isPrivate,int favCnt,int upCnt,int downCnt,String authorPermLink,String body) {
        this.id = id;
        this.isDialogue = isDialogue;
        this.isPrivate = isPrivate;
        this.favCnt = favCnt;
        this.upCnt = upCnt;
        this.downCnt = downCnt;
        this.authorPermLink = authorPermLink;
        this.body = body;
    }


    public String getUrl() {
        return url;
    }

    public int getFavCnt() {
        return favCnt;
    }

    public int getUpCnt() {
        return upCnt;
    }

    public int getDownCnt() {
        return downCnt;
    }

    public String getAuthorPermLink() {
        return authorPermLink;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }

    public boolean isDialogue() {
        return isDialogue;
    }

    public boolean isPrivate() {
        return isPrivate;
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