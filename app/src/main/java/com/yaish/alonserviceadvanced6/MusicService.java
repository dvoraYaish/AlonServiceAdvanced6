package com.yaish.alonserviceadvanced6;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicService extends Service
{
    int length = 0;
    MediaPlayer mediaPlayer;
    static boolean isPlaying = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(this, "onStartCommand", Toast.LENGTH_LONG).show();
        super.onStartCommand(intent, flags, startId);
        if (intent.getStringExtra("action").equals("start")) {
            if (isPlaying)
                mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(this, R.raw.bensoundukulele);
            mediaPlayer.start();
            isPlaying = true;
        } else if (intent.getStringExtra("action").equals("pauseResume")) {
            if (isPlaying) {
                Toast.makeText(this, "pause", Toast.LENGTH_SHORT).show();
                length = mediaPlayer.getCurrentPosition();
                mediaPlayer.pause();
                isPlaying = false;
            } else {
                Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
                mediaPlayer.seekTo(length);
                mediaPlayer.start();
                isPlaying = true;
            }
        }

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();

    }
}
