package com.clarksworld.clarkson.testdraw1.encriptanddecript;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.clarksworld.clarkson.testdraw1.R;

public class SignInActivity extends AppCompatActivity {

    TextView firstName, lastName, phoneNumber, emailAddress, department, status, time;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        firstName = (TextView)findViewById(R.id.firstname);
        lastName = (TextView)findViewById(R.id.lastname);
        phoneNumber = findViewById(R.id.phoneN);
        emailAddress = (TextView)findViewById(R.id.emailA);
        department = (TextView)findViewById(R.id.departmenttext);
        status = (TextView)findViewById(R.id.statusText1);
        time = (TextView)findViewById(R.id.time_tv);
        button = (Button)findViewById(R.id.signup_button);
    }
}
