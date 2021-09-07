package muroga.matsuoka.new_search;


import android.util.Log;
import android.graphics.Bitmap;

import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Calendar;

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
        String url3 = "/area/hokkaido";
        String url4 = "/area/tohoku";
        String url5 = "/area/kanto";
        String url6 = "/area/koshinetsu";
        String url7 = "/area/hokuriku";
        String url8 = "/area/tokai";
        String url9 = "/area/kinki";
        String url10 = "/area/chugoku";
        String url11 = "/area/shikoku";
        String url12 = "/area/kyusyu";
        String url13 = "/area/okinawa";
        String url14 = "/1/l100/";


        getSoup(this.url+url1+url3+url14);
        Elements ele = getElementsFlex();
        Elements ele2 = getElementsP(ele);
        bb[0] = getContent(ele2);
        String[] urlImage = getLinkImage(ele);
        image = getImage(urlImage);
        MainActivity.setImageValues(image);
        MatsuokaActivity2.setImageValues3(image);

        getSoup(this.url+url2+url3+url14);
        Elements ele3 = getElementsFlex();
        Elements ele4 = getElementsP(ele3);
        bb[1] = getContent(ele4);
        return bb;
    }

    Elements getElementsP(Elements e) throws IOException {
        Elements elements = e.select("p");
        return elements;
    }


    String[] getContent(Elements e) throws IOException {
        String[] a = new String[300];
        for (int i = 0; i < e.size(); i++) {
            a[i] = e.get(i).text();
        }
        return a;
    }

    String[] getLinkImage(Elements ele){
        String url = "";
        String url2 = "";
        int cnt = 0;
        Elements ele2 = ele.select("img");
        String[] str = new String[ele2.size()];
        for (int i = 0; i < ele2.size(); i++) {
            url = ele2.get(i).attr("data-original");
            str[i] = url;
        }
        return str;
    }


}
