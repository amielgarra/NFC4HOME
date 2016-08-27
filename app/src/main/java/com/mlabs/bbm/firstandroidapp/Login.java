package com.mlabs.bbm.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by amiel on 7/22/2016.
 */

public class Login extends AppCompatActivity {
    EditText emailTxt;
    EditText passwordTxt;
    Button btnLogin;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        emailTxt = (EditText) findViewById(R.id.emailText);
        passwordTxt = (EditText) findViewById(R.id.passwordText);
        btnLogin = (Button) findViewById(R.id.loginButton);
        show = (TextView) findViewById(R.id.textViewShow);
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

        show.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent){
                int x = motionEvent.getAction();
                //boolean res = false;

                //if(x==motionEvent.ACTION_DOWN){
                //    passwordTxt.setTransformationMethod(null);
                //    res = true;
                //}
                int cursor = passwordTxt.getSelectionStart();
                switch (x){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Login.java", "ACTION_DOWN");
                        passwordTxt.setTransformationMethod(null);
                        passwordTxt.setSelection(cursor);
                        //res = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("Login.java", "ACTION_UP");
                        passwordTxt.setTransformationMethod(new PasswordTransformationMethod());
                        passwordTxt.setSelection(cursor);
                        //res = false;
                        break;
                }

                return true;//res;
            }
        });
    }



    @Override
    protected  void onPause(){
        super.onPause();
        finish(

        );
    }


}