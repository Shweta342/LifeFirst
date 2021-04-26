package com.example.lifefirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OnboardActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
Button get_started_btn;
Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_onboard);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
get_started_btn=findViewById(R.id.get_started);


        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view)
    {
        startActivity(new Intent(this,Navigation.class));
        finish();
    }

    public void letsGetStarted(View view)
    {
        startActivity(new Intent(this,Navigation.class));
        finish();
    }
    private void addDots(int position)
    {
        dots=new TextView[4];
        dotsLayout.removeAllViews();
        for(int i=0;i<dots.length;i++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);

        }
        if(dots.length > 0)
        {
            dots[position].setTextColor(getResources().getColor(R.color.teal_200));
        }

    }


    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position)
        {
addDots(position);
if(position==0)
{
    get_started_btn.setVisibility(View.INVISIBLE);
}
else if(position==1)
{
    get_started_btn.setVisibility(View.INVISIBLE);
}
else if(position==2)
{
    get_started_btn.setVisibility(View.INVISIBLE);
}
else
{
    animation= AnimationUtils.loadAnimation(OnboardActivity.this,R.anim.bottom_anim);
    get_started_btn.setAnimation(animation);
    get_started_btn.setVisibility(View.VISIBLE);
}
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
