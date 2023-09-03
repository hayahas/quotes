//package quotes;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonParseException;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Arrays;
//import java.util.Date;
//
//public class QouteWrapper {
//
//    private Date qouteDate;
//    private Quote quote;
//
//public QouteWrapper(){}
//    public QouteWrapper(Date qouteDate, Quote quote) {
//        this.qouteDate = qouteDate;
//        this.quote = quote;
//
//    }
//
//    public Date getQouteDate() {
//        return qouteDate;
//    }
//
//    public Quote getQuote() {
//        return quote;
//    }
//
//
//    public QouteWrapper getQuotesFromApi() throws IOException {
//        Gson gson = new Gson();
//        //fetch api
//        URL pokeUrl= new URL("https://favqs.com/api/qotd");
//        //open Connection
//        HttpURLConnection pokeUrlConnection = (HttpURLConnection) pokeUrl.openConnection();
//        //set method
//        pokeUrlConnection.setRequestMethod("GET");
//        //read data from api
//        InputStreamReader reader = new InputStreamReader(pokeUrlConnection.getInputStream());
//        BufferedReader bufferedReader=new BufferedReader(reader);
//        String pokeData=bufferedReader.readLine();
//        //print quote in json format
//        // System.out.println(pokeData);
//
//        //format data from api in json,readeble way
//        gson=new GsonBuilder().setPrettyPrinting().create();
//        QouteWrapper newQuote = gson.fromJson(pokeData, QouteWrapper.class);
//        //path & name of new file
//        File filePth = new File("app/src/main/resources/quoteFromApi.json");
//
//        try(FileWriter fileWriter= new FileWriter(filePth)){
//
//            gson.toJson(newQuote, fileWriter);
//
//
//        }catch (IOException | JsonParseException e) {
//
//            e.printStackTrace();
//            throw new RuntimeException(e);
//
//        }
//return newQuote;
//
//    }
//
//    public static Quote[] readQuotesFromFile (String filePath){
//
//        QouteWrapper qw;
//        try(BufferedReader bufferedReader3 = new BufferedReader(new FileReader(filePath))) {
//            Gson gson = new Gson();
//            qw=gson.fromJson(bufferedReader3, QouteWrapper.class);
//
//            //System.out.println(qw);
//            return new Quote[]{qw.getQuote()};
//
//        } catch (IOException | JsonParseException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void saveQuoteToJson(Quote quote, String filePath) {
//        Quote[] existingQuotes = readQuotesFromFile(filePath);
//        Quote[] newQuotes;
//
//        if (existingQuotes != null) {
//            newQuotes = Arrays.copyOf(existingQuotes, existingQuotes.length + 1);
//            newQuotes[existingQuotes.length] = quote;
//        } else {
//            newQuotes = new Quote[]{quote};
//        }
//
//        try (FileWriter writer = new FileWriter(filePath)) {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            gson.toJson(newQuotes, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public String toString() {
//        return ( "Id : " + quote.getId() + "\nQoute : " + quote.getBody() + "\nAuthor : " + quote.getAuthor() +"\nUrl: " + quote.getUrl()
//        );
//    }
//}
package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class QouteWrapper {

    private Date qouteDate;
    private Quote quote;

    public QouteWrapper() {}

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

    public static void main(String[] args) throws IOException {

    }

    public static QouteWrapper getQuotesFromApi() throws IOException {
        Gson gson = new Gson();
        // Fetch API
        URL pokeUrl = new URL("https://favqs.com/api/qotd");
        // Open Connection
        HttpURLConnection pokeUrlConnection = (HttpURLConnection) pokeUrl.openConnection();
        // Set method
        pokeUrlConnection.setRequestMethod("GET");
        // Read data from API
        InputStreamReader reader = new InputStreamReader(pokeUrlConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        String pokeData = bufferedReader.readLine();

        // Format data from API in JSON, readable way
        gson = new GsonBuilder().setPrettyPrinting().create();
        QouteWrapper newQuoteWrapper = gson.fromJson(pokeData, QouteWrapper.class);

        return newQuoteWrapper;
    }

    public static void saveQuotesToJson(List<Quote> quotes, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(quotes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return ("Id : " + quote.getId() + "\nQoute : " + quote.getBody() + "\nAuthor : " + quote.getAuthor() + "\nUrl: " + quote.getUrl());
    }

}
