package br.com.lucaschaves.jkp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgP1;
    ImageView imgP2;

    ImageButton btnPedra;
    ImageButton btnPapel;
    ImageButton btnTesoura;

    Animation show;
    Animation hide;

    MediaPlayer mediaPlayer;

    int jogada1 = 0;
    int jogada2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgP1 = findViewById(R.id.imgP1);
        imgP2 = findViewById(R.id.imgP2);
        btnPedra = findViewById(R.id.btnPedra);
        btnPapel = findViewById(R.id.btnPapel);
        btnTesoura = findViewById(R.id.btnTesoura);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.alex_play);

        hide = new AlphaAnimation(1, 0);
        show = new AlphaAnimation(0, 1);

        hide.setDuration(1500);
        show.setDuration(100);


        hide.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                imgP2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgP2.setVisibility(View.INVISIBLE);
                imgP2.startAnimation(show);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        show.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                drawPlayEnemy();
                imgP2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                verifyPlay();
                imgP2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void tocouBotao(View view) {
        playMusic();
        imgP1.setScaleX(-1f);
        switch (view.getId()) {
            case R.id.btnPedra:
                imgP1.setImageResource(R.drawable.pedra);
                jogada1 = 1;
                break;
            case R.id.btnPapel:
                imgP1.setImageResource(R.drawable.papel);
                jogada1 = 2;
                break;
            case R.id.btnTesoura:
                imgP1.setImageResource(R.drawable.tesoura);
                jogada1 = 3;
                break;
        }
        imgP2.setImageResource(R.drawable.interrogacao);
        imgP2.startAnimation(hide);
    }


    public void drawPlayEnemy() {

        Random r = new Random();
        int numRandom = r.nextInt(3);
        switch (numRandom) {
            case 0:
                imgP2.setImageResource(R.drawable.pedra);
                jogada2 = 1;
                break;
            case 1:
                imgP2.setImageResource(R.drawable.papel);
                jogada2 = 2;
                break;
            case 2:
                imgP2.setImageResource(R.drawable.tesoura);
                jogada2 = 3;
                break;
        }
    }

    public void verifyPlay() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).cancel();
        if (jogada1 == jogada2) {
            Toast.makeText(this, "Empate", Toast.LENGTH_LONG).show();
        }
        if ((jogada1 == 1 && jogada2 == 3) || (jogada1 == 2 && jogada2 == 1) || (jogada1 == 3 && jogada2 == 2)) {
            Toast.makeText(this, "Ganhei!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Perdi!", Toast.LENGTH_LONG).show();
        }
    }

    public void playMusic(){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
        super.onPause();
    }

    @Override
    protected void onStart() {
        mediaPlayer = MediaPlayer.create(this, R.raw.alex_play);
        super.onStart();
    }
}