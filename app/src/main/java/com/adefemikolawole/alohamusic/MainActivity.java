package com.adefemikolawole.alohamusic;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.time.LocalDate;

import static com.adefemikolawole.alohamusic.R.*;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    MediaPlayer mpUkulele, mpDrums;
    int playing;


    private static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Log.d(TAG, "Starting Application from MainActivity");

        button1 = findViewById(id.btnUkulele);
        button2 = findViewById(id.btnDrums);
        button1.setOnClickListener(btUkulele);
        button2.setOnClickListener(btDrums);
        mpUkulele = new MediaPlayer();
        mpUkulele = MediaPlayer.create(this, raw.ukulele);
        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this, raw.drums);
        playing = 0;

    }
    Button.OnClickListener btUkulele = new Button.OnClickListener(){


        @Override
        public void onClick(View v) {
            switch (playing){
                case 0:
                    mpUkulele.start();
                    playing = 1;
                    button1.setText(string.txtPauseUku);
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpUkulele.pause();
                    playing = 0;
                    button1.setText(string.txtPauseUku);
                    button2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    Button.OnClickListener btDrums = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(playing){
                case 0:
                    mpDrums.start();
                    playing = 1;
                    button2.setText(string.txtPlayDru);
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpDrums.pause();
                    playing = 0;
                    button2.setText(string.txtPauseDru);
                    button1.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };


}
