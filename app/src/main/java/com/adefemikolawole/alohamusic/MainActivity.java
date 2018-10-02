package com.adefemikolawole.alohamusic;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    MediaPlayer mpUkulele, mpDrums;
    int playing;


    private static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Starting Application from MainActivity");

        button1 = findViewById(R.id.btnUkulele);
        button2 = findViewById(R.id.btnDrums);
        button1.setOnClickListener(btUkulele);
        button2.setOnClickListener(btDrums);
        mpUkulele = new MediaPlayer();
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this, R.raw.drums);
        playing = 0;

    }
    Button.OnClickListener btUkulele = new Button.OnClickListener(){


        @Override
        public void onClick(View v) {
            switch (playing){
                case 0:
                    mpUkulele.start();
                    playing = 1;
                    button1.setText("Pause Ukulele Song");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpUkulele.pause();
                    playing = 0;
                    button1.setText("Play Ukulele Song");
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
                    button2.setText("Pause Drum Song");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpDrums.pause();
                    playing = 0;
                    button2.setText("Play Drum Song");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };


}
