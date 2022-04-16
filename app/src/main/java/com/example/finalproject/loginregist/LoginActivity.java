package com.example.finalproject.loginregist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.main.MainActivity;
import com.example.finalproject.session.SharedPreference;
import com.example.finalproject.model.User;
import com.example.finalproject.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {


    TextView signUp;
    TextView terms;
    TextView forgot;
    EditText email;
    EditText pass;
    Button btnLogin;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        myDb = new DatabaseHelper(this);

        String text = "By Signing up, you agree with our Terms & Conditions";

        signUp = findViewById(R.id.sign_up_fragment);
        terms = findViewById(R.id.tv_terms);
        forgot = findViewById(R.id.tv_forgot);
        email = findViewById(R.id.et_email_login);
        pass = findViewById(R.id.et_password_login);
        btnLogin = findViewById(R.id.btn_login);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPassActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _email = email.getText().toString();
                String _pass = pass.getText().toString();

                if(email.getText().toString().isEmpty() && pass.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Email and Password can't be empty", Toast.LENGTH_SHORT).show();
                }
                else if(email.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Email can't be empty", Toast.LENGTH_SHORT).show();
                }
                else if(pass.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Password can't be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean check = myDb.getUser(_email, _pass);
                    if(check == true)
                    {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        SQLiteDatabase db = myDb.getReadableDatabase();
                        Cursor cursor = db.rawQuery("SELECT * FROM MsUser WHERE Email=? AND Password=?",new String[]{_email, _pass});
                        if(cursor!=null && cursor.getCount()>0){
                            cursor.moveToFirst();
                            SharedPreference sharedPreference = new SharedPreference(LoginActivity.this);
                            sharedPreference.save(new User(
                                    cursor.getString(cursor.getColumnIndex("Name")),
                                    cursor.getString(cursor.getColumnIndex("Email")),
                                    cursor.getString(cursor.getColumnIndex("Password")),
                                    cursor.getString(cursor.getColumnIndex("JobPosition")),
                                    cursor.getString(cursor.getColumnIndex("Title"))
                            ));
                        }

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(LoginActivity.this, TermsActivity.class);
                startActivity(intent);
            }
        };

        ss.setSpan(clickableSpan, 34, 52, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ForegroundColorSpan(Color.rgb(0,255,255)), 34, 52, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        terms.setText(ss);
        terms.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
