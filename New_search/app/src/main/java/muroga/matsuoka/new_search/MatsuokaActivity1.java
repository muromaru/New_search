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


    }



    public static void setImageValues2 (Bitmap[]i){

        imageValues2 = i;
    }

}