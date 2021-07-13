package muroga.matsuoka.new_search;


import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import java.io.IOException;


public class AsyncWork extends AsyncTask<Void, Void, String[][]> {
    private String[][] textValues;

    @Override
    protected String[][] doInBackground(Void... params) {
        try {
            Content content = new Content();
            textValues = content.start();
            Log.d("abc", "Async success");
        } catch (IOException e) {
            Log.e("abc", "error");
            Log.e("abc", e.getMessage());
        }
        return textValues;
    }

    @Override
    protected void onPostExecute(String[][] result) {
        MainActivity.setTextValues(result);
        Log.d("abc", "onPost");
    }

}