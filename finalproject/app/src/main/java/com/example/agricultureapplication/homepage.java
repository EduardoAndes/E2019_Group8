package com.example.agricultureapplication;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    NavController navController;
    TextView logout;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //NAVIGATION
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);


        //BOTTOM NAVIGATION
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this,  R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_profile:
                Toast.makeText(this,"Profile", Toast.LENGTH_SHORT).show();

                int profile = item.getItemId();

                if(profile == R.id.nav_profile){

                    Intent intent = new Intent(homepage.this,Profile.class);
                    startActivity(intent);

                    return true;
                }
                break;
            case R.id.nav_security:
                Toast.makeText(this,"Home", Toast.LENGTH_SHORT).show();
                int security = item.getItemId();

                if(security == R.id.nav_security){

                    Intent intent = new Intent(homepage.this,ReportProblem.class);
                    startActivity(intent);

                    return true;
                }
                break;
            case R.id.nav_setting:
                Toast.makeText(this,"Setting", Toast.LENGTH_SHORT).show();

                break;
            case R.id.nav_logout:
                Toast.makeText(this,"Logout", Toast.LENGTH_SHORT).show();
                int logout = item.getItemId();

                if(logout == R.id.nav_logout){

                    Intent intent = new Intent(homepage.this,LoginActivity.class);
                    startActivity(intent);

                    return true;
                }
                break;
            case R.id.nav_about_us:
                Toast.makeText(this,"About Us", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}