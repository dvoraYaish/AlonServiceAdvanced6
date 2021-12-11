package com.yaish.alonserviceadvanced6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MY", "OnCreate");

    }

    public void onStartMusicPressed(View view)
    {
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra("action","start");
        startService(intent);

    }

    public void onPauseMusicPressed(View view)
    {
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra("action","pause");
        startService(intent);
    }

    public void onResumeMusicPressed(View view)
    {
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra("action","resume");
        startService(intent);
    }
}