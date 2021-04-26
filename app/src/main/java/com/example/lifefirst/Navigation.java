package com.example.lifefirst;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Navigation extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Dashboard");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));

        if(savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MainActivity()).commit();
            navigationView.setCheckedItem(R.id.dashboard);
        }


    }



    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }}

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainActivity()).commit();
                break;
            case R.id.maps:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SecondFragment()).commit();
                break;
            case R.id.oxygen:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ThirdFragment()).commit();
                break;
            case R.id.symptoms:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FourthFragment()).commit();
                break;
            case R.id.info:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FifthFragment()).commit();
                break;
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SixthFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
