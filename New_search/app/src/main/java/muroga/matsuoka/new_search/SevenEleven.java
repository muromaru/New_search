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

    public void flow() throws IOException {
        getInfo();
    }

}
