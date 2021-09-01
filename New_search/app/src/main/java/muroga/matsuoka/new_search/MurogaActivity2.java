package muroga.matsuoka.new_search;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MurogaActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muroga2);



        //Intent intent = getIntent();
        TextView textView = findViewById(R.id.text_view);
        textView.setText("あああああああ");
        textView.setTextColor(Color.RED);



        Button button = (Button)findViewById(R.id.myButton);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = getIntent();
                        String a = intent.getStringExtra("TEst");
                        TextView textView = findViewById(R.id.text_view);
                        textView.setText(a);
                        finish();
                    }
                }
        );

        Resources r = getResources();
        Bitmap bmp1 = BitmapFactory.decodeResource(r, R.drawable.star);
        Bitmap bmp2 = BitmapFactory.decodeResource(r, R.drawable.star2);
        Bitmap bmp3 = BitmapFactory.decodeResource(r, R.drawable.star3);

        ImageView image1 = findViewById(R.id.imageview_1);
        ImageView image2 = findViewById(R.id.imageview_2);
        ImageView image3 = findViewById(R.id.imageview_3);

        image1.setImageBitmap(bmp1);
        image2.setImageBitmap(bmp2);
        image3.setImageBitmap(bmp3);



    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("LifeCycle", "onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("LifeCycle", "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("LifeCycle", "onPause");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d("LifeCycle", "onRestart");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d("LifeCycle", "onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("LifeCycle", "onDestroy");
    }

}





