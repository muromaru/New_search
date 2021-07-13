package muroga.matsuoka.new_search;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.io.IOException;
import java.util.Calendar;

public class Lawson extends Shop {


    String[] a = new String[100];
    String[][] bb = new String[10][100];
    Bitmap[] image = new Bitmap[100];
    int cnt = 2;


    public Lawson() throws IOException {
        super();
        this.name = "lawson";
        this.url = "https://www.lawson.co.jp";
    }

    public String[][] flow() throws IOException {
        getInfo();
        getSoup(this.url);
        Elements ele = getElementsP();
        String url = getLink(ele);
        url = this.url + url;
        getSoup(url);
        Elements ele2 = getElements();
        url = getLink2(ele2);
        url = this.url + url;
        getSoup(url);
        Elements ele3 = getElementsP();
        ele2 = getElementsA();
        url = getLinkOtherDay(ele2);
        url = this.url + url;
        getSoup(url);
        Elements ele4 = getElementsP();
        url = getLinkOtherDay(ele2);
        url = this.url + url;
        getSoup(url);
        Elements ele5 = getElementsP();
        url = getLinkOtherDay(ele2);
        url = this.url + url;
        getSoup(url);
        Elements ele6 = getElementsP();
        url = getLinkOtherDay(ele2);
        url = this.url + url;
        getSoup(url);
        Elements ele7 = getElementsP();
        url = getLinkOtherDay(ele2);
        url = this.url + url;
        getSoup(url);
        Elements ele8 = getElementsP();
        url = getLinkOtherDay(ele2);
        url = this.url + url;
        getSoup(url);
        Elements ele9 = getElementsP();
        url = getLinkOtherDay(ele2);
        url = this.url + url;
        getSoup(url);
        Elements ele10 = getElementsP();
        bb[0] = getContent(ele3);
        bb[1] = getContent(ele4);
        bb[2] = getContent(ele5);
        bb[3] = getContent(ele6);
        bb[4] = getContent(ele7);
        bb[5] = getContent(ele8);
        String[] urlImage = getLinkImage(ele3);
        for(int i=0;i<urlImage.length;i++){
            urlImage[i] = this.url + urlImage[i];
        }
        image = getImage(urlImage);
        MainActivity.setImageValues(image);
//        bb[6] = getContent(ele9);
//        bb[7] = getContent(ele10);
        Log.d("abc", "l.flow finish");
        return bb;
    }






    String getLink(Elements soup) throws IOException {
        String str1 = "新商品";
        String url = "";

        Elements s1 = soup.select("a");
        for (Element i : s1) {
            if (str1.equals(i.text())){
                url = i.attr("href");
            }
        }
        return url;
    }

    String getLink2(Elements soup) throws IOException {
        String url = "";
        Elements s2 = soup.select("meta");
        for(Element element : s2){
            url = element.attr("content");
            url = url.split("URL=")[1];
        }
        return url;
    }

    String getLinkOtherDay(Elements soup) throws IOException {
        String str1 = "新商品";
        String url = "";

        Elements s1 = soup.select("a");
        //Log.d("abc", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        for (int i = 0; i < s1.size(); i++) {
            if (str1.equals(s1.get(i).text())){
                //Log.d("abc", s1.get(i).text());
                //Log.d("abc", s1.get(i+cnt).text());
                //Log.d("abc", String.valueOf(i));
                //Log.d("abc", String.valueOf(i+cnt));
                url = s1.get(i+cnt).attr("href");
                //Log.d("abc", url);
            }
        }
        cnt++;
        return url;
    }

    String[] getContent(Elements e) throws IOException {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        String str1 = "発売日" + String.valueOf(year) + "." + String.valueOf(month+1) + "." + String.valueOf(date);
        String str2 = "発売日2020.10.06";
        String[] a = new String[300];
        int cnt = 0;
        Elements ele2 = e.select("img");

        for(int day=0; day<40; day++) {
            date = date-1;
            if (date==0){
                month = month-1;
                date=31;
            }
            if (month==0){
                year = year-1;
                month = 12;
            }
            str1 = "発売日" + String.valueOf(year) + "." + String.format("%02d",month+1) + "." + String.format("%02d",date);
            //Log.d("abc", str1);
            for (int i = 0; i < e.size(); i++) {
                Log.d("abc", e.get(i).attr("src"));
                if (str1.equals(e.get(i).text())) {
                    //              Log.d("abc", e.get(i-2).attr("src"));
                    //                Log.d("abc", e.get(i-2).text());
                    //                Log.d("abc", e.get(i-1).text());
                    //               Log.d("abc", e.get(i).text());
                    //                Log.d("abc", "\n");
                    a[cnt] = e.get(i - 3).text();
                    a[cnt + 1] = e.get(i - 2).text();
                    a[cnt + 2] = e.get(i - 1).text();
                    a[cnt + 3] = e.get(i).text();
                    a[cnt + 4] = "\n";
                    cnt = cnt + 5;
                }
            }
        }
        return a;
    }

}



