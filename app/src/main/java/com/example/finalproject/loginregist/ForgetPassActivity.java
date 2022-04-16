package com.example.finalproject.loginregist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.database.DatabaseHelper;

public class ForgetPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        final EditText email = findViewById(R.id.et_email_user);
        Button cont = findViewById(R.id.btn_cont_reset);
        final DatabaseHelper myDb = new DatabaseHelper(this);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = myDb.checkUser(email.getText().toString());
                if(check == false)
                {
                    Intent intent = new Intent(ForgetPassActivity.this, ResetPassActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(ForgetPassActivity.this, ForgetPassActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
