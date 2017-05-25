package com.example.himanshu.smartpark.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.himanshu.smartpark.R;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin, btnSignUp;
    EditText etEmail, etPassword;
    String email, password;
    Boolean emailValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        Log.e("debug","loginstart");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();

                emailValidate = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
                if(isValidate())
                {
                    Intent intent = new Intent(LoginActivity.this,BookParkingActivity.class);
                    intent.putExtra("mode","login");
                    startActivity(intent);

                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

    }

    public void init() {
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnSignUp = (Button) findViewById(R.id.btn_signup);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
    }

    public boolean isValidate()
    {
        if(email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"All Fields Are Mandatory",Toast.LENGTH_SHORT).show();
            return false;
        } else if(!emailValidate)
        {
            Toast.makeText(getApplication(),"Invalid Email Format",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
