package com.clarksworld.clarkson.testdraw1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.clarksworld.clarkson.testdraw1.R;

/**
 * Created by CLARKSWORLD on 25/04/2018.
 */

public class SplashScreenActivty extends AppCompatActivity {


    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.splash_image);
        textView  = findViewById(R.id.splash_tv);




        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {

                Intent i = new Intent(SplashScreenActivty.this, UserSignupAuthActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
