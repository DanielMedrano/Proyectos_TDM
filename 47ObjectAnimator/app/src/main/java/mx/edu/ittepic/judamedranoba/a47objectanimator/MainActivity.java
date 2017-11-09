package mx.edu.ittepic.judamedranoba.a47objectanimator;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RelativeLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.sol);
        canvas = (RelativeLayout) findViewById(R.id.animationCanvas);
    }

    public void onButtonClick(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();

        ObjectAnimator a1 = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetY,2)
                .setDuration(4000);
        a1.setInterpolator(new BounceInterpolator());
        a1.start();

    }

    public void onButton2Click(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();

        ObjectAnimator a = ObjectAnimator.ofFloat(
                imageView, "rotationX", 360f, 0f);
        a.setDuration(4000);
        a.setInterpolator(new DecelerateInterpolator());
        a.start();

    }

    public void onButton3Click(View v) {

        ObjectAnimator a2 = ObjectAnimator.ofFloat(
                imageView, "rotationY", 0f, 360f);
        a2.setDuration(4000);
        a2.setInterpolator(new CycleInterpolator(2));
        a2.start();

    }

}
