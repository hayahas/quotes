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
import java.util.Random;

public class QuoteTest {
//    @Test void toStringReturnRandomQuoteAndItsAuthor(){
//
//        Gson gson = new Gson();
//        Quote[] q;
//        Quote myQuote=null;
//        try(BufferedReader bufferedReader= new BufferedReader(new FileReader("app/src/main/resources/recentquotes.json"));){
//            q=gson.fromJson(bufferedReader, Quote[].class);
//            if(q.length != 0 && q != null ){
//                int random =  (int)Math.floor(Math.random() * (q.length - 0 + 1) + 0);
//                myQuote=q[random];
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        String result= myQuote.toString();
//        String otpt = "Qoute : " + myQuote.getText() + "\nAuthor : " + myQuote.getAuthor();
//        Assertions.assertEquals(otpt,result);
//    }

    @Test void quoteWrapperToString_returnsRandomQuoteAndItsAuthorAndOtherData() throws IOException {
        Gson gson = new Gson();
        URL pokeUrl= new URL("https://favqs.com/api/qotd");

        HttpURLConnection pokeUrlConnection = (HttpURLConnection) pokeUrl.openConnection();

        pokeUrlConnection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(pokeUrlConnection.getInputStream());
        BufferedReader bufferedReader=new BufferedReader(reader);
        String pokeData=bufferedReader.readLine();

        gson=new GsonBuilder().setPrettyPrinting().create();
        QouteWrapper newQuote = gson.fromJson(pokeData, QouteWrapper.class);

        File filePth = new File("app/src/main/resources/quoteFromApi.json");

        try(FileWriter fileWriter= new FileWriter(filePth)){

            gson.toJson(newQuote, fileWriter);


        }catch (IOException | JsonParseException e) {

            e.printStackTrace();
            throw new RuntimeException(e);

        }
        QouteWrapper qw;
        try(BufferedReader bufferedReader3 = new BufferedReader(new FileReader("app/src/main/resources/quoteFromApi.json"))) {
            qw=gson.fromJson(bufferedReader3, QouteWrapper.class);

            System.out.println(qw);


        } catch (IOException | JsonParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Quote q =new Quote();
        String result= qw.toString();
        String otpt = "Id : " + q.getId() + "\nQoute : " + q.getBody() + "\nAuthor : " + q.getAuthor() +"\nUrl: " + q.getUrl();

        Assertions.assertEquals(otpt,result);
    }

    }
