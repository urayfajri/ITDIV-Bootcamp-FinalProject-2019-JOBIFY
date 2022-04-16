package com.example.finalproject.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.model.User;
import com.example.finalproject.session.SharedPreference;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView;

        TextView navName;
        TextView navEmail;

        loadFragment(new HomeFragment());

        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        View headerView = navigationView.getHeaderView(0);
        navName = headerView.findViewById(R.id.tv_navname);
        navEmail = headerView.findViewById(R.id.tv_navemail);

        setSupportActionBar(toolbar);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.setTitle("Home");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        SharedPreference sharedPreference = new SharedPreference(MainActivity.this);
        User user = sharedPreference.load();
        navName.setText(user.getName());
        navEmail.setText(user.getEmail());

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_my_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_take_a_look:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LookFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_bookmark:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BookmarkFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_mailbox:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ApplyboxFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_trash:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TrashFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HelpFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_log_out:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LogoutFragment()).addToBackStack(null).commit();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }
        return false;
    }
}
