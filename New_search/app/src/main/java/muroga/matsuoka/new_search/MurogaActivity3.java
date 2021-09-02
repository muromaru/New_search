package muroga.matsuoka.new_search;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MurogaActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muroga3);

        TextView textView = findViewById(R.id.text__view);
        textView.setText("えええええ");
        textView.setTextColor(Color.RED);

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
