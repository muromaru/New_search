package muroga.matsuoka.new_search;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MatsuokaActivity1 extends AppCompatActivity {

    public static Bitmap[] imageValues2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matsuoka1);


        ImageView image1 = findViewById(R.id.imageview_1);
        image1.setImageBitmap(imageValues2[1]);

        ImageView image2 = findViewById(R.id.imageview_2);
        image2.setImageBitmap(imageValues2[2]);

        ImageView image3 = findViewById(R.id.imageview_3);
        image3.setImageBitmap(imageValues2[3]);

        ImageView image4 = findViewById(R.id.imageview_4);
        image4.setImageBitmap(imageValues2[4]);

        ImageView image5 = findViewById(R.id.imageview_5);
        image5.setImageBitmap(imageValues2[5]);

        ImageView image6 = findViewById(R.id.imageview_6);
        image6.setImageBitmap(imageValues2[6]);

        ImageView image7 = findViewById(R.id.imageview_7);
        image7.setImageBitmap(imageValues2[7]);


    }



    public static void setImageValues2 (Bitmap[]i){

        imageValues2 = i;
    }

}