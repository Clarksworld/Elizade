package com.clarksworld.clarkson.testdraw1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.clarksworld.clarkson.testdraw1.BaseActivity;
import com.clarksworld.clarkson.testdraw1.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by CLARKSWORLD on 14/05/2018.
 */

public class UserSignupAuthActivity extends AppCompatActivity {



    ImageView signInImage;


    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    public ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset, lecturerButton;
    public String matNum = "EU130304-242";
    public String password8 = "12345";
    public String matNum1 = "EU130304-240";
    public String password1 = "123";
    public String matNum2 = "EU140306-533";
    public String password2 = "124";
    public String matNum3 = "EU140305-332";
    public String password3 = "332";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_signup);

        lecturerButton = findViewById(R.id.lecturer_button);
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        btnSignup = findViewById(R.id.signup);
        btnLogin = findViewById(R.id.btn_login);
        btnReset = findViewById(R.id.password_reset);


        lecturerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserSignupAuthActivity.this, LecturerSignInActivity.class);
                startActivity(intent);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserSignupAuthActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserSignupAuthActivity.this, ResetPasswordActivity.class));
            }
        });
        userAuth();


    }

    public void userAuth() {


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                firstUser();
                progressBar.setVisibility(View.GONE);

            }
        });


    }

    public void firstUser() {

        String email = inputEmail.getText().toString();
        final String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }


        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }


        if (email.equals(matNum) && password.equals(password8)) {
            Intent intent = new Intent(UserSignupAuthActivity.this, BaseActivity.class);
            startActivity(intent);

        } else if (email.equals(matNum1) && password.equals(password1)) {


            Intent intent = new Intent(UserSignupAuthActivity.this, BaseActivity.class);
            startActivity(intent);

        } else if (email.equals(matNum2) && password.equals(password2)) {
            Intent intent = new Intent(UserSignupAuthActivity.this, BaseActivity.class);
            startActivity(intent);
        } else if (email.equals(matNum3) && password.equals(password3)) {
            Intent intent = new Intent(UserSignupAuthActivity.this, BaseActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(UserSignupAuthActivity.this, "invalid Email Address," + " or incorrect password check and try again", Toast.LENGTH_SHORT).show();
        }

        progressBar.setVisibility(View.VISIBLE);


    }

}
