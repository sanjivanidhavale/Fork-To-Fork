package com.example.farmtofork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    //private TextView textView;
    TextView registerbutton,forgotmpin;
    Button radio1,radio2,btnlogin;
    EditText inputnumber;
    RadioGroup radio_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        if (SharedPrefManager.getInstance(this).isLoggedIn()){
//            finish();
//            startActivity((new Intent(this,NavigationDrawerActivity.class)));
//            return;
//        }
        registerbutton = findViewById(R.id.textViewSignUp);
        btnlogin = findViewById(R.id.btnlogin);
        forgotmpin = findViewById(R.id.forgotPassword);
        inputnumber = findViewById(R.id.inputnumber);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio_group = findViewById(R.id.radio_group);


        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputnumber.getText().toString();
                if (!inputnumber.getText().toString().trim().isEmpty()) {
                    if ((inputnumber.getText().toString().trim()).length() == 10) {
                        Toast.makeText(LoginActivity.this, radio1.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Login_Mpin.class); //Login is activity
                        intent.putExtra("Name",name);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(LoginActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputnumber.getText().toString();
                if (!inputnumber.getText().toString().trim().isEmpty()) {
                    if ((inputnumber.getText().toString().trim()).length() == 10) {
                        Toast.makeText(LoginActivity.this, radio2.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), OTP_Verification.class); //Login is activity
                        intent.putExtra("Name",name);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginActivity.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(LoginActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = inputnumber.getText().toString();
//                if (!inputnumber.getText().toString().trim().isEmpty()) {
//                    if ((inputnumber.getText().toString().trim()).length() == 10) {
//                        int selectedid = radio_group.getCheckedRadioButtonId();
//                        btnlogin =(RadioButton)findViewById(selectedid);
//                        if (!(selectedid == -1)) {
//                            Toast.makeText(LoginActivity.this, radio1.getText(), Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getApplicationContext(), Login_Mpin.class); //Login is activity
//                            intent.putExtra("Name",name);
//                            startActivity(intent);
//                            finish();
//                            if((!(selectedid == 1))){
//                                Toast.makeText(LoginActivity.this, radio2.getText(), Toast.LENGTH_SHORT).show();
//                                Intent intent1 = new Intent(getApplicationContext(), LoginOTP_Verification.class); //Login is activity
//                                intent1.putExtra("Name",name);
//                                startActivity(intent1);
//                                finish();
//                            }
//                        } else {
//                        }
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
//                    }
//                } else{
//                    Toast.makeText(LoginActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(LoginActivity.this, RegisterPage.class);
                startActivity(myIntent);
            }
        });

        forgotmpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputnumber.getText().toString();
                if (!inputnumber.getText().toString().trim().isEmpty()) {
                    if ((inputnumber.getText().toString().trim()).length() == 10) {
                        Toast.makeText(LoginActivity.this, forgotmpin.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Forgot_Mpin.class); //Login is activity
                        intent.putExtra("Name",name);
                        startActivity(intent);


                    } else {
                        Toast.makeText(LoginActivity.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(LoginActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}