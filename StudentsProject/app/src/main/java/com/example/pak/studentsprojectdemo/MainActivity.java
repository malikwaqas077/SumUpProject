package com.example.pak.studentsprojectdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText mUserName, mPassowrd;
    TextView mTxtView;
    Button mSigninBtn;
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session=new SessionManager(getApplicationContext());
        if (session.isLoggedIn()){
            Intent intent=new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        mSigninBtn=(Button) findViewById(R.id.login_btn);
        mTxtView=(TextView) findViewById(R.id.signup_txt_view);
        mSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserName=(EditText) findViewById(R.id.user_name_edit_txt);
                mPassowrd=(EditText) findViewById(R.id.password_edit_txt);
                Toast.makeText(MainActivity.this, mUserName.getText().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, mPassowrd.getText().toString(), Toast.LENGTH_SHORT).show();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, getApplicationContext().getString(R.string.login), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        if(response.equalsIgnoreCase("Data Matched")){
                            Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);

                        }
                        session.setLogin(true);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("pEmail", mUserName.getText().toString());
                        params.put("pPassword", mPassowrd.getText().toString());
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                requestQueue.add(stringRequest);

            }
        });
        mTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
