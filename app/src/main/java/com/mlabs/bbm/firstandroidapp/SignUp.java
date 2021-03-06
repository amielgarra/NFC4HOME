package com.mlabs.bbm.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Created by amiel on 10/7/2016.
 */
public class SignUp extends AppCompatActivity implements android.view.View.OnClickListener {

    EditText fname;
    EditText lname;
    EditText uname;
    EditText email;
    EditText password;
    EditText confirmpass;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        fname = (EditText) findViewById(R.id.TvFName);
        lname = (EditText) findViewById(R.id.TvLName);
        uname = (EditText) findViewById(R.id.TvUName);
        email = (EditText) findViewById(R.id.TvNewEmail);
        password = (EditText) findViewById(R.id.TvNewPass);
        confirmpass = (EditText) findViewById(R.id.TvConfirmNewPass);
        create = (Button) findViewById(R.id.BtnCreate);

        fname.requestFocus();

        create.setOnClickListener(this);

    }
    public void onClick(View view) {
        if (view == findViewById(R.id.BtnCreate)){
            if (Pattern.compile("^\\w+.*\\w*@[a-zA-Z_]+?\\.[0-9a-zA-Z]{2,}(\\.[0-9a-zA-Z]{2,})?$").matcher(email.getText()).matches())
            {
                if (password.getText().toString().equals(confirmpass.getText().toString())){
                    if (password.getText().toString().length() >= 8){
                        Account acct = new Account();
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        String formattedDate = df.format(c.getTime());
                        if (Pattern.compile("^\\w+.*\\w*@[a-zA-Z_]+?\\.[0-9a-zA-Z]{2,}(\\.[0-9a-zA-Z]{2,})?$").matcher(uname.getText()).matches()) {
                            Toast.makeText(getBaseContext(), "Username should not be in Email format.", Toast.LENGTH_SHORT).show();
                        }else {

                            AccountRepo repo = new AccountRepo(this);
                            acct.acct_firstname = fname.getText().toString();
                            acct.acct_lastname = lname.getText().toString();
                            acct.acct_username = uname.getText().toString();
                            acct.acct_email = email.getText().toString();
                            acct.acct_password = password.getText().toString();
                            acct.acct_datecreated = formattedDate;
                            if(repo.isExisting(acct) == false) {
                                int a = 0;
                                a = repo.createAccount(acct);
                                Toast.makeText(this, "New account added!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUp.this, Login.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getBaseContext(), "Username/Email already exists!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else  {
                        Toast.makeText(this, "Password must contain 8 or more characters.", Toast.LENGTH_SHORT).show();
                    }
                }
                else   {
                    Toast.makeText(this, "Password does not match.", Toast.LENGTH_SHORT).show();
                }
            }
            else   {
                Toast.makeText(this, "Incorrect e-mail format.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    protected  void onPause() {
        super.onPause();
        finish();
    }
}
