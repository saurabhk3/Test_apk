package com.saurabh.projetct_101;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView background;
    ImageButton playButton;
    Float inc = 0.1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = findViewById(R.id.imageView);
        playButton = findViewById(R.id.playButton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startTimer(30000);
    }
    public void startTimer(final long t){
        new CountDownTimer(t, 1000){
            public void onTick(long milliUntilFinished){
                playButton.setAlpha(1.0f-inc);
                inc += 0.15f;
                if(inc >= 0.8f){
                    inc = 0.1f;
                }
            }
            public void onFinish(){
                playButton.setAlpha(1.0f);
                startTimer(t);
            }
        }.start();
    }

    public void start(View view){
        Toast.makeText(this, "Yeah!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
       // menuInflater.inflate(R.menu.menu_opt,menu);
        return true;
    }
}
