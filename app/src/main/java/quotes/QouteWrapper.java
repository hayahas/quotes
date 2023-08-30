package quotes;

import java.util.Date;

public class QouteWrapper {

    private Date qouteDate;
    private Quote quote;


    public QouteWrapper(Date qouteDate, Quote quote) {
        this.qouteDate = qouteDate;
        this.quote = quote;

    }

    public Date getQouteDate() {
        return qouteDate;
    }

    public Quote getQuote() {
        return quote;
    }
    @Override
    public String toString() {
        return ( "Id : " + quote.getId() + "\nQoute : " + quote.getBody() + "\nAuthor : " + quote.getAuthor() +"\nUrl: " + quote.getUrl()
        );
    }
}
