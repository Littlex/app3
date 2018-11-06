package com.example.shuangxi.app3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.FrameLayout;

// define DetailsActivity so that when the phone is in portrait mode and user clicks interest point,
// it will open another window to show official page of that point of interest

public class DetailsActivity extends Activity {

    private WebView wv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // If the screen is now in landscape mode, we don't need this activity.
            finish();
            return;
        }

        // otherwise start another webview showing the official page of interest points
        int index = getIntent().getIntExtra("index", 0);

        setContentView(R.layout.webview);
        wv = (WebView) findViewById(R.id.webView);
        String url = getResources().getStringArray(R.array.SanFinterests_url)[index];

        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setAppCacheEnabled(true);
        wv.loadUrl(url);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

}