package muroga.matsuoka.new_search;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import muroga.matsuoka.new_search.Lawson;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    //private ImageView imageView0;
    private static String[][] textValues;
    private static Bitmap[] imageValues;
    private final String[] spinnerArea = {"北海道", "東北", "関東", "甲信越","東海","近畿","中国","四国","九州","沖縄"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        final ImageView imageView0 = findViewById(R.id.imageview0);
        final ImageView imageView1 = findViewById(R.id.imageview1);
        final ImageView imageView2 = findViewById(R.id.imageview2);
        final ImageView imageView3 = findViewById(R.id.imageview3);
        final ImageView imageView4 = findViewById(R.id.imageview4);
        final ImageView imageView5 = findViewById(R.id.imageview5);


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
                imageView2.setImageBitmap(imageValues[2]);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe3");
                String str = String.join("\n", textValues[3]);
                textView.setText(str);
                imageView3.setImageBitmap(imageValues[3]);
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
                textView.setText(str);
                imageView4.setImageBitmap(imageValues[4]);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe5");
                String str = String.join("\n", textValues[5]);
                textView.setText(str);
                textView.setText(str);
                imageView5.setImageBitmap(imageValues[5]);

            }
        });

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerArea);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                Spinner spinner = (Spinner)parent;
                String item = (String)spinner.getSelectedItem();
                textView.setText(item);
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

        //ここからスクロール機能!!!
        /**
         * 画像のスクロールを試すための画面を表します。
         */
        public class TestImageScrollActivity extends Activity implements OnClickListener, OnTouchListener {
            /**
             * 画像の表示モードが CENTER であることを示すテキスト。
             */
            private static final String DISPLAY_MODE_CENTER = "Center";

            /**
             * 画像の表示モードが FIT_CENTER であることを示すテキスト。
             */
            private static final String DISPLAY_MODE_FIT_CENTER = "Fit Center";

            /**
             * 画像の表示方法。
             */
            private ScaleType mImageScaleType = ScaleType.CENTER;

            /**
             * 画像が表示領域における、X 軸方向の一辺からはみ出る量。
             * 例えば画像の幅が 1080、表示領域は 480 の場合、「( 1080 - 480 ) / 2 = 300」とする。
             * 画像より表示領域が大きいならば、この値はゼロとなる。
             */
            private int mOverX;

            /**
             * 画像が表示領域における、Y 軸方向の一辺からはみ出る量。
             * 例えば画像の高さが 720、表示領域は 480 の場合、「( 720 - 480 ) / 2 = 120」とする。
             * 画像より表示領域が大きいならば、この値はゼロとなる。
             */
            private int mOverY;

            /**
             * 画像を表示するための View。
             */
            private ImageView mImageView;

            /**
             * 画像の表示モードとなるテキスト。
             */
            private TextView mDisplayModeTextView;

            /**
             * タッチの始点となる X 座標。
             */
            private float mTouchBeginX;

            /**
             * タッチの始点となる Y 座標。
             */
            private float mTouchBeginY;

            /**
             * 画面と画像のサイズを元に、一辺からはみ出る量を算出します。
             *
             * @param display 画面のサイズ。
             * @param image   画像のサイズ。
             *
             * @return 一辺からはみ出る量。画面に画像が収まる場合はゼロ。
             */
            private static int calcOverValue( int display, int image ) {
                return ( display < image ? ( image - display ) / 2 : 0 );
            }

            /**
             * スクロール量を算出します。
             *
             * @param move 移動する予定の量。
             * @param pos  現在のスクロール座標
             * @param over 画像が表示領域の一辺からはみ出る量。
             *
             * @return スクロール量。
             */
            private static int calcScrollValue( int move, int pos, int over ) {
                int newPos = pos + move;
                if( newPos < -over ) {
                    move = -( over + pos );

                } else if( over < newPos ) {
                    move = over - pos;
                }

                return move;
            }

            /**
             * 画面の設定が変更された時に発生します。
             *
             * @param newConfig 新しい設定。
             */
            @Override
            public void onConfigurationChanged( Configuration newConfig ) {
                super.onConfigurationChanged( newConfig );

                this.updateOverSize();
                this.mImageView.scrollTo( 0, 0 );
            }

            /**
             * 画面が作成された時に発生します。
             *
             * @param savedInstanceState 保存されたインスタンスの状態。
             */
            @Override
            public void onCreate( Bundle savedInstanceState ) {
                super.onCreate( savedInstanceState );
                this.setContentView( R.layout.activity_main );

                this.mDisplayModeTextView = ( TextView )this.findViewById( R.id.display_mode );
                this.mDisplayModeTextView.setText( DISPLAY_MODE_CENTER );
                this.mDisplayModeTextView.setOnClickListener( this );

                this.mImageView = ( ImageView )this.findViewById( R.id.image_view );
                this.mImageView.setScaleType( this.mImageScaleType );
                this.mImageView.setOnTouchListener( this );

                this.updateOverSize();
            }

            /**
             * View がクリックされた時に発生します。
             *
             * @param v クリックされた View。
             */
            public void onClick( View v ) {
                if( this.mImageScaleType == ScaleType.CENTER ) {
                    this.mImageScaleType = ScaleType.FIT_CENTER;
                    this.mDisplayModeTextView.setText( DISPLAY_MODE_FIT_CENTER );

                } else {
                    this.mImageScaleType = ScaleType.CENTER;
                    this.mDisplayModeTextView.setText( DISPLAY_MODE_CENTER );
                }

                this.mImageView.setScaleType( this.mImageScaleType );
                this.mImageView.scrollTo( 0, 0 );
            }

            /**
             * View がタッチされた時に発生します。
             *
             * @param v     タッチされた View。
             * @param event イベント データ。
             *
             * @return タッチ操作を他の View へ伝搬しないなら true。する場合は false。
             */
            public boolean onTouch( View v, MotionEvent event ) {
                if( this.mImageScaleType == ScaleType.FIT_CENTER ) { return false; }

                switch( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        this.mTouchBeginX = event.getX();
                        this.mTouchBeginY = event.getY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        float x = event.getX(), y = event.getY();
                        this.scrollImage( x, y );

                        this.mTouchBeginX = x;
                        this.mTouchBeginY = y;
                        break;

                    case MotionEvent.ACTION_UP:
                        this.scrollImage( event.getX(), event.getY() );
                        break;
                }

                return true;
            }

            /**
             * 画像をスクロールさせます。
             *
             * @param x 移動先の基準となる画面内の X 軸の座標。
             * @param y 移動先の基準となる画面内の Y 軸の座標。
             */
            private void scrollImage( float x, float y ) {
                int moveX = ( this.mOverX == 0 ? 0 : calcScrollValue( ( int )( this.mTouchBeginX - x ), this.mImageView.getScrollX(), this.mOverX ) );
                int moveY = ( this.mOverY == 0 ? 0 : calcScrollValue( ( int )( this.mTouchBeginY - y ), this.mImageView.getScrollY(), this.mOverY ) );
                this.mImageView.scrollBy( moveX, moveY );
            }

            /**
             * 画像と表示領域を比較し、はみ出る量を算出します。
             */
            private void updateOverSize() {
                Display display = ( (WindowManager)this.getSystemService( Context.WINDOW_SERVICE ) ).getDefaultDisplay();
                Drawable image   = this.mImageView.getDrawable();

                this.mOverX = calcOverValue( display.getWidth(),  image.getIntrinsicWidth()  );
                this.mOverY = calcOverValue( display.getHeight(), image.getIntrinsicHeight() );
            }
        }
    }
    //ここまでがスクロール機能

    public static void setTextValues(String[][] t) {
        textValues = t;
        //final TextView textView1;
        //textView1 = findViewById(R.id.textview);
        //textView1.setText("OK!!!!!");
    }

    public static void setImageValues(Bitmap[] i) { imageValues = i; }

}