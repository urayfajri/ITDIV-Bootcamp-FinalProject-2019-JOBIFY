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

public class ResetPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        final EditText email = findViewById(R.id.et_reset_email);
        final EditText pass = findViewById(R.id.et_reset_pass);
        final EditText confpass = findViewById(R.id.et_conf_pass);
        Button reset = findViewById(R.id.btn_reset_password);
        final DatabaseHelper myDb = new DatabaseHelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = myDb.checkUser(email.getText().toString());
                if(check == true && (pass.getText().toString().equals(confpass.getText().toString())))
                {
                    myDb.updatePass(email.getText().toString(), pass.getText().toString());
                    Toast.makeText(getApplicationContext(), "Update Password Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetPassActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else if(!pass.getText().toString().equals(confpass.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Password Not Match", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetPassActivity.this, ResetPassActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetPassActivity.this, ResetPassActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
