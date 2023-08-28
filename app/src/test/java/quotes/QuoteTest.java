package quotes;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class QuoteTest {
    @Test void toStringReturnRandomQuoteAndItsAuthor(){

        Gson gson = new Gson();
        Quote[] q;
        Quote myQuote=null;
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader("C:\\Users\\USER\\newforGradle\\quotes\\app\\src\\main\\resources\\recentquotes.json"));){
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
        Assertions.assertEquals(otpt,result);
    }

    }
