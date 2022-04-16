package com.example.finalproject.loginregist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.main.MainActivity;
import com.example.finalproject.session.SharedPreference;
import com.example.finalproject.model.User;
import com.example.finalproject.database.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    Spinner spinner;
    TextView terms;
    TextView login;
    EditText username;
    EditText email;
    EditText password;
    EditText r_password;
    Button btnRegister;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String text = "By Signing up, you agree with our Terms & Conditions";

        spinner = findViewById(R.id.spinner);
        terms = findViewById(R.id.tv_terms);
        login = findViewById(R.id.login_fragment);
        username = findViewById(R.id.et_username_register);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password_register);
        r_password = findViewById(R.id.et_repeat_password);
        btnRegister = findViewById(R.id.btn_register);
        myDb = new DatabaseHelper(this);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (RegisterActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray
                        (R.array.position));

        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        SpannableString ss = new SpannableString(text);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _name = username.getText().toString();
                String _email = email.getText().toString();
                String _pass = password.getText().toString();
                String _job;
                String text = spinner.getSelectedItem().toString();
                if(text.equals("Candidate"))
                {
                    _job = "unemployed";
                }
                else
                {
                    _job = "";
                }
                String _title = _job;

                if(username.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Name can't be empty", Toast.LENGTH_LONG).show();
                }
                else if(email.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Email can't be empty", Toast.LENGTH_LONG).show();
                }
                else if(!password.getText().toString().equals(r_password.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Password Not Match", Toast.LENGTH_LONG).show();
                }
                else
                {
                    boolean check = myDb.checkUser(_email);
                    if(check == true)
                    {
                        boolean ins = myDb.insert(_name, _email, _pass, _job, _title);
                        if(ins == true)
                        {
                            Toast.makeText(getApplicationContext(), "Register Success", Toast.LENGTH_LONG).show();
                            SharedPreference sharedPreference = new SharedPreference(RegisterActivity.this);
                            sharedPreference.save(new User(
                                    _name, _email, _pass, _job, _title
                            ));

                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Data Already Exists", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegisterActivity.this, RegisterActivity.class);
                        startActivity(intent);
                    }
                }
                finish();
            }
        });

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(RegisterActivity.this, TermsActivity.class);
                startActivity(intent);
            }
        };

        ss.setSpan(clickableSpan, 34, 52, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ForegroundColorSpan(Color.rgb(0,255,255)), 34, 52, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        terms.setText(ss);
        terms.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
