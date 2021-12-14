package com.yaish.alonserviceadvanced6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    Button btPauseResume;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MY", "OnCreate");
        intViews();

    }

    private void intViews()
    {
        btPauseResume = findViewById(R.id.btPauseResumeMusic);
    }

    public void onStartMusicPressed(View view)
    {
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra("action","start");
        startService(intent);
        btPauseResume.setText("pause");


    }

    public void onPauseResumeMusicPressed(View view)
    {
        changeText(view);
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra("action","pauseResume");
        startService(intent);
    }

    private void changeText(View view)
    {
        if(btPauseResume.getText().equals("pause"))
            btPauseResume.setText("resume");
        else
            btPauseResume.setText("pause");

    }


}