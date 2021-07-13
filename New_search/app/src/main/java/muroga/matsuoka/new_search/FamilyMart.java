package muroga.matsuoka.new_search;


import android.graphics.Bitmap;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import android.util.Log;

import java.io.IOException;

public class FamilyMart extends Shop {

    //private Document document;
    String[] a = new String[100];
    String[][] bb = new String[10][100];
    Bitmap[] image = new Bitmap[100];
    int cnt = 0;


    public FamilyMart() throws IOException {
        super();
        this.name = "family_mart";
        this.url = "https://www.family.co.jp/goods/newgoods";
    }

    public String[][] flow() throws IOException {
        getInfo();
        Log.d("abc", "aaa111");
        getSoup(this.url);
        String[] str1 = getElementsAll();
        Log.d("abc", "aaa222");
        //bb[0] = getText(str1);


        return bb;
    }





    String[] getText(Elements ele){

        return a;
    }

    Elements getElementsCate() throws IOException{
        Document document = getDocument();
        Elements elements = document.select("[class=ly-mod-infoset4-cate]");
        return elements;
    }
    Elements getElementsTtl() throws IOException{
        Document document = getDocument();
        Elements elements = document.select("[class=ly-mod-infoset4-ttl]");
        return elements;
    }
    Elements getElementsTxt() throws IOException{
        Document document = getDocument();
        Elements elements = document.select("[class=ly-mod-infoset4-txt]");
        return elements;
    }
    String[] getElementsAll() throws IOException{
        Document document = getDocument();
        Elements elements = document.select("[class=ly-mod-infoset4-txt],[class=ly-mod-infoset4-ttl]");
        String[] a = new String[100];
        String str = "";
        for (int i = 0; i < elements.size(); i++) {
            str += elements.get(i).text();
            if(i%2==1){
                int num = i/2;
                a[num] = str;
                str = "";
            }
        }
        return a;
    }




}
