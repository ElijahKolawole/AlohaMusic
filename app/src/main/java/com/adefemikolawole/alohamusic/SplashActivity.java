package com.adefemikolawole.alohamusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

            }
        };
        Timer opening = new Timer(); // an instance of timer
        opening.schedule(task, 5000); // timer scheduled for 5 seconds.
        finish(); //releases the resources that were created for the Splash Activity and closes the activity.
        startActivity(new Intent(SplashActivity.this, MainActivity.class)); //start activity in SplachAcvtivity launches the second class whichh is MainActivity



    }
}
