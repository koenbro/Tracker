package com.koenbro.android.tracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/*
Uses code from https://newcircle.com/s/post/60/servicesdemo_using_android_services
 */
public class MainActivity extends Activity implements OnClickListener {
    private static final String TAG = "ServicesDemo";
    Button buttonStart, buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop  = (Button) findViewById(R.id.buttonStop);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.buttonStart:
                Log.d(TAG, "onClick: starting service");
                startService(new Intent(this, LocationTrackerService.class));
                break;
            case R.id.buttonStop:
                Log.d(TAG, "onClick: stopping service");
                stopService(new Intent(this, LocationTrackerService.class));
                break;
        }
    }
}
