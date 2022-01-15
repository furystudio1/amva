package com.agntic.waves.khadamat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.agntic.waves.Dialog.Dialog;
import com.agntic.waves.ListVOD.VODvideo;
import com.agntic.waves.Main;
import com.agntic.waves.Music.MusicList;
import com.agntic.waves.R;
import com.bugsnag.android.Bugsnag;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class khadamat extends Activity {

    ImageView imageView1,imageView2,imageView3;
    TextView textView1,textView2;
    RelativeLayout relativeLayout1,relativeLayout2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bugsnag.start(this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.khadamat);

        imageView1 = findViewById(R.id.backkhadamat);
        imageView2 = findViewById(R.id.backres);
        imageView3 = findViewById(R.id.backcafe);
        textView1 = findViewById(R.id.txtrec);
        textView2 = findViewById(R.id.txtcafe);
        relativeLayout1 = findViewById(R.id.btnrec);
        relativeLayout2 = findViewById(R.id.btncaffe);


        //Get file font
        Typeface typeface = Typeface.createFromAsset(getAssets(), "IRANSansMobile.ttf");

        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);

        relativeLayout1.setFocusableInTouchMode(true);
        relativeLayout1.setFocusable(true);
        relativeLayout2.setFocusableInTouchMode(true);
        relativeLayout2.setFocusable(true);


        Glide.with(khadamat.this)
                .load(R.drawable.backkhadamat)
                .transition(DrawableTransitionOptions.withCrossFade())
                //.diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(bitmapTransform(new BlurTransformation(42)))
                .into(imageView1);



        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent uou = new Intent(khadamat.this, Returant.class);
                startActivity(uou);
                khadamat.this.finish();

            }
        });


        relativeLayout1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus){
                    v.animate().scaleY(1.2f).scaleX(1.2f).start();
                }else {
                    v.animate().scaleY(1f).scaleX(1f).start();
                }

            }
        });



        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent uou = new Intent(khadamat.this, Coffe.class);
                startActivity(uou);
                khadamat.this.finish();

            }
        });

        relativeLayout2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus){
                    v.animate().scaleY(1.2f).scaleX(1.2f).start();
                }else {
                    v.animate().scaleY(1f).scaleX(1f).start();
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {


        Intent uou = new Intent(khadamat.this, Main.class);
        uou.putExtra("from",2);
        startActivity(uou);

        finish();

        super.onBackPressed();
    }
}
