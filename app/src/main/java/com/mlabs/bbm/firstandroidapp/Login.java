package com.mlabs.bbm.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.*;

/**
 * Created by amiel on 7/22/2016.
 */

public class Login extends AppCompatActivity {
    EditText emailTxt;
    EditText passwordTxt;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        emailTxt = (EditText) findViewById(R.id.emailText);
        passwordTxt = (EditText) findViewById(R.id.passwordText);
        btnLogin = (Button) findViewById(R.id.loginButton);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[0-9a-zA-Z]{2,}$").matcher(emailTxt.getText()).matches())
                {
                    if (passwordTxt.length()>=8)
                    {
                        Intent intent = new Intent(Login.this,MainActivity.class );
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(),"Password must be at least 8 characters.", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Invalid e-mail address.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}