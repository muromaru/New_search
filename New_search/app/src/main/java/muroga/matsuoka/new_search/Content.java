package muroga.matsuoka.new_search;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import muroga.matsuoka.new_search.Shop;

import java.io.IOException;

public class Content{

    String[][] start()throws IOException {
        //SevenEleven s = new SevenEleven();
        //Log.d("abc", "seven_eleven start");
        //String[][] a = s.flow();

        FamilyMart f = new FamilyMart();
        Log.d("abc", "family_mart start");
        String[][] a = f.flow();
        Log.d("abc",""+a[0][50]);

        //Lawson l = new Lawson();
        //Log.d("abc", "lawson start!!!");
        //String[][] a = l.flow();

        return a;
    }







}

