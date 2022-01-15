package com.agntic.waves;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

public class Testmove extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.testmove);

        RelativeLayout relativeLayout = findViewById(R.id.testmove);

        ObjectAnimator animation = ObjectAnimator.ofFloat(relativeLayout, "translationX", -400f);
        animation.setDuration(2000);
        animation.start();

        new Handler().postDelayed(new Thread() {

            @Override
            public void run() {
                super.run();

                relativeLayout.setVisibility(View.INVISIBLE);

            }
        }, 2000);
        new Handler().postDelayed(new Thread() {

            @Override
            public void run() {
                super.run();

                relativeLayout.setVisibility(View.VISIBLE);
                ObjectAnimator animation2 = ObjectAnimator.ofFloat(relativeLayout, "translationX", 400f);
                animation2.setDuration(2000);
                animation2.start();

            }
        }, 2500);


    }
}
