package com.example.calculator;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class chek_login extends AppCompatActivity {
    private EditText login;
    private EditText password;
    private Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_log);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.sign_in_btn);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Не верный логин или пароль!", Toast.LENGTH_SHORT);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")){
                    Intent intent;
                    intent = new Intent(chek_login.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    toast.show();
                }
            }
        });


    }
}