package com.example.farmtofork;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterPage extends AppCompatActivity implements View.OnClickListener {
    Button Submit, radio1, radio2;
    EditText et_mobileno;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

//        if (SharedPrefManager.getInstance(this).isLoggedIn()){
//            finish();
//            startActivity((new Intent(this,NavigationDrawerActivity.class)));
//            return;
//        }


        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        et_mobileno = findViewById(R.id.et_mobileno);

        progressDialog = new ProgressDialog(this);

        radio1.setOnClickListener(this);
    }
    private void registerUser(){
        final String number= et_mobileno.getText().toString().trim();
        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constant.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(getApplicationContext(),jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("number", number);
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);


//        radio1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),Generate_Mpin.class);
//                startActivity(intent);
//            }
//        });




//        radio2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),OTP_Verification.class);
//                startActivity(intent);
//            }
//        });
//        getSupportActionBar().hide();

    }

    @Override
    public void onClick(View view) {
        String name = et_mobileno.getText().toString();
        if (view == radio1){
            registerUser();
            Intent intent = new Intent(getApplicationContext(),Generate_Mpin.class);
            intent.putExtra("Name",name);
            startActivity(intent);
        }


    }
}