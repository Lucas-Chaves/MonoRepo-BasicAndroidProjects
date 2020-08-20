package br.com.lucaschaves.appalfandega;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {


    ImageView imgArrow;
    TextView txtMenu;

    Animation show;
    Animation hide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMenu = findViewById(R.id.txtMenu);
        imgArrow = findViewById(R.id.imgArrow);
        show = new AlphaAnimation(0,1);
        hide = new AlphaAnimation(1,0);
        show.setDuration(500);
        hide.setDuration(500);

        txtMenu.setText("Toque para começar");
        imgArrow.setVisibility(View.INVISIBLE);

        show.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imgArrow.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgArrow.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        hide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imgArrow.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgArrow.setVisibility(View.INVISIBLE);
                txtMenu.setText("Toque para continuar");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void clickScreen(View view){
        if(Math.random() < 0.5){
            txtMenu.setText("Siga para Esquerda");
            imgArrow.setScaleX(1f);
        }else {
            txtMenu.setText("Siga para Direita");
            imgArrow.setScaleX(-1f);
        }

        imgArrow.startAnimation(show);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                imgArrow.startAnimation(hide);
            }
        }, 2000);
    }







}