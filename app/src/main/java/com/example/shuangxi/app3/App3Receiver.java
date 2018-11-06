package com.example.shuangxi.app3;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class App3Receiver extends BroadcastReceiver {

    private static final String TOAST_INTENT_SF =    // intent action for choosing San Francisco
            "com.example.shuangxi.app1.SF";
    private static final String TOAST_INTENT_NY =    // intent action for choosing New York
            "com.example.shuangxi.app1.NY";

    @Override
    public void onReceive(Context arg0, Intent arg1) {

        String action = arg1.getAction();    // get the intent action information
        if (action ==  TOAST_INTENT_NY) {    // if the intent is sent by clicking New York button, sent toast message that says
            // The New York information is under construction
            Toast.makeText(arg0, "The New York information is under construction. --App3",
                    Toast.LENGTH_LONG).show() ;

        } else if (action ==  TOAST_INTENT_SF) {    // if intent is sent by clicking San Francisco button, startActivity to show
            // interest points of San Francisco

            Intent intent = new Intent();
            intent.setClass(arg0, SFActivity.class);
            arg0.startActivity(intent);
        }
    }
}