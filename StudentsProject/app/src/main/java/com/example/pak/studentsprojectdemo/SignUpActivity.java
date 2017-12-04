package com.example.pak.studentsprojectdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    EditText Uname,Email,Password,Phone;
    Button Signupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Uname=(EditText)findViewById(R.id.uname_edit_txt);
        Email=(EditText)findViewById(R.id.email_edit_txt);
        Password=(EditText)findViewById(R.id.password_edit_text);
        Phone=(EditText)findViewById(R.id.phone_edit_txt);
        Signupbtn=(Button)findViewById(R.id.signup_btn);


    }
}
