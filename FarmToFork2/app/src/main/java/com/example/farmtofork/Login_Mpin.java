package com.example.farmtofork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class Login_Mpin extends AppCompatActivity implements View.OnClickListener {

    Button btn_submit;
    TextView tv_number, tv_forgotpassword;
    EditText ed_mpin;
    private ProgressDialog progressDialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_mpin);

            if(SharedPrefManager.getInstance(this).isLoggedIn()){
                finish();
                startActivity(new Intent(this, NavigationDrawerActivity.class));
                return;
            }
            tv_forgotpassword= findViewById(R.id.tv_forgotpassword);
            tv_number =  findViewById(R.id.tv_number);
            ed_mpin = findViewById(R.id.ed_mpin);
            btn_submit =findViewById(R.id.btn_submit);

            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please wait...");

            btn_submit.setOnClickListener(this);

            Intent intent = getIntent();
            String name = intent.getStringExtra("Name");

            TextView mResult = findViewById(R.id.tv_number);
            mResult.setText(""+name);

            tv_forgotpassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = tv_number.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), Forgot_Mpin.class);
                    intent.putExtra("Name",name);
                    startActivity(intent);
                }
            });

        }





        private void userLogin(){
            final String number = tv_number.getText().toString().trim();
            final String mpin = ed_mpin.getText().toString().trim();

            progressDialog.show();

            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST,
                    Constant.URL_LOGIN,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            try {
                                JSONObject obj = new JSONObject(response);
                                if(!obj.getBoolean("error")){
                                    SharedPrefManager.getInstance(getApplicationContext())
                                            .userLogin(
                                                    obj.getInt("id"),
                                                    obj.getString("number"),
                                                    obj.getString("mpin")
                                            );
                                    Toast.makeText(getApplicationContext(), "User login Successful", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(), NavigationDrawerActivity.class));
                                    finish();
                                }else{
                                    Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();

                            Toast.makeText(
                                    getApplicationContext(),
                                    error.getMessage(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }
                    }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("number", number);
                    params.put("mpin", mpin);
                    return params;
                }

            };

            RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
        }


    @Override
    public void onClick(View v) {
        if(v == btn_submit){
            userLogin();
        }
    }

}