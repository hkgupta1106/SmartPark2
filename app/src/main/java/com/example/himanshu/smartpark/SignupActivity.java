package com.example.himanshu.smartpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.smartpark.model.UserDataModel;

import io.paperdb.Paper;

public class SignupActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etConfirmPassword;
    Button btnSignup;
    String name, email, password, confirmPassword;
    Boolean emailValidate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                name = etName.getText().toString();
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();
                confirmPassword = etConfirmPassword.getText().toString();
                emailValidate = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

                if(isValidate())
                {
                    Toast.makeText(getApplication(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                    UserDataModel userDataModel = new UserDataModel(name,email,password);
                    Paper.book().write("customerInfo",userDataModel);
                    Intent intent = new Intent(SignupActivity.this,BookParkingActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void init()
    {
        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        etConfirmPassword = (EditText) findViewById(R.id.et_confirmpassword);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        Paper.init(getApplicationContext());
    }

    public Boolean isValidate()
    {
        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty())
        {
            Toast.makeText(getApplication(),"All Fields Are Mandatory",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!emailValidate)
        {
            Toast.makeText(getApplication(),"Invalid Email Format",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!confirmPassword.equals(password))
        {
            Toast.makeText(getApplication(),"Password does'nt match",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
