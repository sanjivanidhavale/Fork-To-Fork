package com.example.farmtofork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OTP_Verification extends AppCompatActivity {

    TextView tv_verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        getSupportActionBar().hide();
        tv_verify = findViewById(R.id.tv_verify);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");

        TextView mResult = findViewById(R.id.tv_verify);
        mResult.setText("Verfication code is send to"+name);
    }
}