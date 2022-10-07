package com.example.farmtofork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Generate_Mpin extends AppCompatActivity {
    EditText edit1,edit2;
    TextView tv_forgotpassword;
    Button btn_submit;
    TextView tv_number;
    private static final String UPDATE_URL = "http://192.168.29.112/farm%20to%20fork/update/update.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_mpin);
        edit1 = findViewById(R.id.inputmpin);
        edit2 = findViewById(R.id.inputconfirmmpin);
        tv_forgotpassword = findViewById(R.id.tv_forgotpassword);
        btn_submit= findViewById(R.id.btn_submit);
        tv_number = findViewById(R.id.tv_number);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        TextView mResult = findViewById(R.id.tv_number);
        mResult.setText(""+name);
        edit1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(edit1.getText().toString().length()==6)     //size as per your requirement
                {
                    edit2.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        tv_forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Forgot_Mpin.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().hide();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateUser();
                Intent intent = new Intent(getApplicationContext(), NavigationDrawerActivity.class);
                startActivity(intent);
            }
        });
    }
    // Update User
    private void UpdateUser() {

        String number =tv_number.getText().toString().trim();
        String mpin = edit1.getText().toString().trim().toLowerCase();
        String confirm_mpin = edit2.getText().toString().trim().toLowerCase();

        registers(number,mpin,confirm_mpin);

    }
    private void registers(String number, String mpin, String confirm_mpin) {
        class RegisterUsers extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Generate_Mpin.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String, String>();
                data.put("number", params[0]);
                data.put("mpin", params[1]);
                data.put("confirm_mpin", params[2]);

                String result = ruc.sendPostRequest(UPDATE_URL, data);

                return result;
            }
        }
        RegisterUsers ru = new RegisterUsers();
        ru.execute(number,mpin,confirm_mpin);

    }
}