package mx.edu.ittepic.judamedranoba.a49ppot;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimationDrawable Animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.animation);
        if (imageView == null) throw new AssertionError();

        imageView.setVisibility(View.INVISIBLE);
        imageView.setBackgroundResource(R.drawable.animation);

        Animation = (AnimationDrawable) imageView.getBackground();
        Animation.setOneShot(true);
    }

    public void onStartBtnClick(View v) {
        int img = (int) (Math.random() * 3);
        imageView.setVisibility(View.VISIBLE);
        if (Animation.isRunning()) {
            Animation.stop();
        }
        imageView.setVisibility(View.VISIBLE);
        Animation.start();
        Log.d("Variable img: ",""+img);
        if(img == 0){Animation.addFrame(getResources().getDrawable(R.drawable.piedra),100);};
        if(img == 1){Animation.addFrame(getResources().getDrawable(R.drawable.papel),100);};
        if(img == 2){Animation.addFrame(getResources().getDrawable(R.drawable.tijera),100);};
    }

}
