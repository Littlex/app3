package com.example.shuangxi.app3;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;


/* The DetailsFragment return a webview to show the official page of interest points  */

public class DetailsFragment extends Fragment {

    private WebView webView = null;
    private int mCurrIdx = -1;

    public int getShownIndex() {
        return mCurrIdx;
    }

    // Show the webview at position newIndex
    void showQuoteAtIndex(int newIndex) {
        if (newIndex < 0)
            return;
        mCurrIdx = newIndex;
        String url = getResources().getStringArray(R.array.SanFinterests_url)[mCurrIdx];
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.loadUrl(url);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    // create the UI with a Webview and return a reference to
    // the Webview which is then drawn to the screen

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.webview,
                container, false);

    }

   // create a webview onActivityCreated
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        webView = (WebView) getActivity().findViewById(R.id.webView);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}