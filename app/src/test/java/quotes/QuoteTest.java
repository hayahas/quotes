package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static quotes.QouteWrapper.getQuotesFromApi;


public class QuoteTest {
    @Test void toStringReturnRandomQuoteAndItsAuthor(){

        Gson gson = new Gson();
        Quote[] q;
        Quote myQuote=null;
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader("src/test/resources/recentquotes.json"));){
            q=gson.fromJson(bufferedReader, Quote[].class);
            if(q.length != 0 && q != null ){
                int random =  (int)Math.floor(Math.random() * (q.length - 0 + 1) + 0);
                myQuote=q[random];
            }
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        String result= myQuote.toString();
        String otpt = "Qoute : " + myQuote.getText() + "\nAuthor : " + myQuote.getAuthor();
        assertEquals(otpt,result);
    }

    @Test
    public void testGetQuotesFromApi() {

        try {
            QouteWrapper newQuoteWrapper = QouteWrapper.getQuotesFromApi();
            assertNotNull(newQuoteWrapper);
            Quote newQuote = newQuoteWrapper.getQuote();
            assertNotNull(newQuote);
        } catch (Exception e) {
            Assertions.fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testFileUpdate() throws IOException {
        List<Quote> quoteList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            QouteWrapper newQuoteWrapper = getQuotesFromApi();
            Quote newQuote = newQuoteWrapper.getQuote();
            quoteList.add(newQuote);
        }

        String filePath = "src/test/resources/quoteFromApi.json";


        QouteWrapper.saveQuotesToJson(quoteList, filePath);

        QouteWrapper updatedQuotes = getQuotesFromApi();
        assertNotNull(updatedQuotes);

    }

}
