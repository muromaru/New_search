package muroga.matsuoka.new_search;


import android.graphics.Bitmap;

import java.io.IOException;

public class SevenEleven extends Shop {

    String[] a = new String[100];
    String[][] bb = new String[10][100];
    Bitmap[] image = new Bitmap[100];
    int cnt = 0;


    public SevenEleven() throws IOException {
        super();
        this.name = "seven_eleven";
        this.url = "https://www.sej.co.jp";
    }

    public String[][] flow() throws IOException {
        getInfo();
        String url1 = "/products/a/thisweek";
        String url2 = "/products/a/nextweek";
        String url_h = "/area/hokkaido";
        getSoup(this.url+url1+url_h);
        getElementsFlex();
        return bb;
    }

}
