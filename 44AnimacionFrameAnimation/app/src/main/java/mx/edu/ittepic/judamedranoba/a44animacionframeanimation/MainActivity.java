package mx.edu.ittepic.judamedranoba.a44animacionframeanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimationDrawable horseAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.animation);
        if (imageView == null) throw new AssertionError();

        imageView.setVisibility(View.INVISIBLE);
        imageView.setBackgroundResource(R.drawable.horseanimation);

        horseAnimation = (AnimationDrawable) imageView.getBackground();
        horseAnimation.setOneShot(true);
    }

    public void onStartBtnClick(View v) {
        imageView.setVisibility(View.VISIBLE);
        if (horseAnimation.isRunning()) {
            horseAnimation.stop();
        }
        horseAnimation.start();
    }

    public void onStopBtnClick(View v) {
        horseAnimation.stop();
    }



}
