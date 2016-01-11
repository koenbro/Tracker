package com.koenbro.android.tracker;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * @author laszlo
 * @date 1/10/16.
 */
public class LocationTrackerService extends Service {
    private static final String TAG = "LocationTrackerService";
    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Starting", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate");
        player = MediaPlayer.create(this, R.raw.braincandy);
        player.setLooping(false);
//        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Stopping", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
        player.stop();
//        super.onDestroy();
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service Starting", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
        player.start();
    }

}


