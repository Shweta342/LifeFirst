package com.example.lifefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {
    private static int Splash_timer=5500;

    ImageView bgimg,logo;
    LottieAnimationView lottieAnimationView1;
    SharedPreferences onBoardingscreens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        bgimg = findViewById(R.id.bg);
        logo = findViewById(R.id.logo);
        lottieAnimationView1 = findViewById(R.id.lottie);


        bgimg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView1.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
new Handler().postDelayed(() -> {

    onBoardingscreens=getSharedPreferences("onBoardingscreens",MODE_PRIVATE);

    boolean isFirstTime=onBoardingscreens.getBoolean("First time",true);
    if(isFirstTime)
    {
        SharedPreferences.Editor editor=onBoardingscreens.edit();
        editor.putBoolean("First time",false);
        editor.commit();

        Intent i=new Intent(SplashScreen.this,OnboardActivity.class);
        startActivity(i);
        finish();
    }
    else
    {
        Intent i=new Intent(SplashScreen.this,MainActivity.class);
        startActivity(i);
        finish();
    }



    Intent i=new Intent(SplashScreen.this,OnboardActivity.class);
    startActivity(i);
    finish();

},Splash_timer);

    }



            }

