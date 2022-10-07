package com.example.farmtofork;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginOTP_Verification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginotp_verification);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");

        TextView mResult = findViewById(R.id.tv_verify);
        mResult.setText("Verification code is send to"+name);
    }
}