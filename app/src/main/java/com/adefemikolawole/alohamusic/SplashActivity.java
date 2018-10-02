package com.adefemikolawole.alohamusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private static String TAG = SplashActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d(TAG, "Starting Application from MainActivity");

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                finish(); //releases the resources that were created for the Splash Activity and closes the activity.
                startActivity(new Intent(SplashActivity.this, MainActivity.class)); //start activity in SplachAcvtivity launches the second class whichh is MainActivity

            }
        };
        Timer opening = new Timer(); // an instance of timer
        opening.schedule(task, 5000); // timer scheduled for 5 seconds.



    }
}
