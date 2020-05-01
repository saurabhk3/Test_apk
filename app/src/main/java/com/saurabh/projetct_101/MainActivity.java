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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView background;
    ImageButton playButton;
    Float inc = 0.1f,textInc=0.5f;
    TextView playTextView;
    float currentXpos,currentYpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = findViewById(R.id.imageView);
        playButton = findViewById(R.id.playButton);
        playTextView = findViewById(R.id.playTextView);
        currentXpos = playButton.getScaleX();
        currentYpos = playButton.getScaleY();
    }

    @Override
    protected void onStart() {
        super.onStart();
        startTimer(30000);
    }
    public void startTimer(final long t){
        new CountDownTimer(t, 400){
            public void onTick(long milliUntilFinished){
                playTextView.setAlpha(textInc);
                if(textInc==0.5f){
                    textInc = 1.0f;
                }else{
                    textInc = 0.5f;
                }

                playButton.setAlpha(1.0f-inc);
                playButton.setScaleX(currentXpos+0.5f*inc);
                playButton.setScaleY(currentYpos+0.5f*inc);
                inc += 0.2f;
                if(inc >= 0.8f){
                    inc = 0.2f;
                }
            }
            public void onFinish(){
                playButton.setAlpha(1.0f);
                playTextView.setAlpha(textInc);
                playButton.setScaleX(currentXpos);
                playButton.setScaleY(currentYpos);
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
//        menuInflater.inflate(R.menu.menu_opt,menu);
        return true;
    }
}
