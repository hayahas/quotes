package quotes;

import java.util.Date;

public class QouteWrapper {

    private Date qouteDate;
    private Quote quote;

    private String url;
    private int favCnt;
    private int upCnt;
    private int downCnt;
    private String author;
    private  String authorPermLink;
    private String body;

    public QouteWrapper(Date qouteDate, Quote quote, String url, int favCnt, int upCnt, int downCnt, String author, String authorPermLink, String body) {
        this.qouteDate = qouteDate;
        this.quote = quote;
        this.url = url;
        this.favCnt = favCnt;
        this.upCnt = upCnt;
        this.downCnt = downCnt;
        this.author = author;
        this.authorPermLink = authorPermLink;
        this.body = body;
    }

    public Date getQouteDate() {
        return qouteDate;
    }

    public Quote getQuote() {
        return quote;
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

    public String getAuthor() {
        return author;
    }

    public String getAuthorPermLink() {
        return authorPermLink;
    }

    public String getBody() {
        return body;
    }
}
