package com.gayatrisoft.jaipurjyotish;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashActivity extends AppCompatActivity {

    Animation animation, animationimage;
    TextView tv;
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        tv = findViewById(R.id.tv);
        ivLogo = findViewById(R.id.ivLogo);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        animationimage = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tv.setAnimation(animation);
        ivLogo.setAnimation(animationimage);

        new PrefetchData().execute();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run( ) {
                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }

    private class PrefetchData extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPreExecute( ) {
            super.onPreExecute();
            // before making http calls

        }

    }

}
