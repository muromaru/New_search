package muroga.matsuoka.new_search;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import muroga.matsuoka.new_search.Lawson;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    //private ImageView imageView0;
    private static String[][] textValues;
    private static Bitmap[] imageValues;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        final ImageView imageView0 = findViewById(R.id.imageview0);
        final ImageView imageView1 = findViewById(R.id.imageview1);

        AsyncWork asyncWork = new AsyncWork();
        asyncWork.execute();

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button0.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe0");
                String str = String.join("\n", textValues[0]);
                textView.setText(str);
                imageView0.setImageBitmap(imageValues[0]);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe1");
                String str = String.join("\n", textValues[1]);
                textView.setText(str);
                imageView1.setImageBitmap(imageValues[1]);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe2");
                String str = String.join("\n", textValues[2]);
                textView.setText(str);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe3");
                String str = String.join("\n", textValues[3]);
                textView.setText(str);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe4");
                String str = String.join("\n", textValues[4]);
                textView.setText(str);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe5");
                String str = String.join("\n", textValues[5]);
                textView.setText(str);
            }
        });
    }

    public static void setTextValues(String[][] t) {
        textValues = t;
        //final TextView textView1;
        //textView1 = findViewById(R.id.textview);
        //textView1.setText("OK!!!!!");
    }

    public static void setImageValues(Bitmap[] i) { imageValues = i; }

}