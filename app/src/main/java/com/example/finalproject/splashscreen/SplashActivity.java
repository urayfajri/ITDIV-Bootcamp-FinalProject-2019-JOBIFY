package com.example.finalproject.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.database.DatabaseHelper;
import com.example.finalproject.loginregist.LoginActivity;
import com.example.finalproject.main.MainActivity;
import com.example.finalproject.model.User;
import com.example.finalproject.session.SharedPreference;

public class SplashActivity extends AppCompatActivity {

    private int SPLASH_TIME_OUT = 2500;
    LinearLayout splash;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        myDb = new DatabaseHelper(this);
        splash = findViewById(R.id.popup_splash);

        final Boolean check;
        SharedPreference sharedPreference = new SharedPreference(SplashActivity.this);
        User user = sharedPreference.load();
        if(user.getName().isEmpty())
        {
            check = false;
        }
        else
        {
            check = true;
            SQLiteDatabase db = myDb.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM MsUser WHERE Email=? AND Password=?",new String[]{user.getEmail(), user.getPassword()});
            if(cursor!=null && cursor.getCount()>0){
                cursor.moveToFirst();
                sharedPreference.save(new User(
                        cursor.getString(cursor.getColumnIndex("Name")),
                        cursor.getString(cursor.getColumnIndex("Email")),
                        cursor.getString(cursor.getColumnIndex("Password")),
                        cursor.getString(cursor.getColumnIndex("JobPosition")),
                        cursor.getString(cursor.getColumnIndex("Title"))
                ));
            }

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                popupSplash(true);
                if(check == false)
                {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        }, SPLASH_TIME_OUT);

    }

    private void popupSplash(boolean isShow){
        splash.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

}
