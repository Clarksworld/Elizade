package com.clarksworld.clarkson.testdraw1.encriptanddecript;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.clarksworld.clarkson.testdraw1.R;

public class EncryptSignUpActivity extends AppCompatActivity {

    EditText firstName, lastName, phoneNumber,  email;

    TextView department_tv, status_tv;

    Spinner departmentSpinner, statusSpinner;

    Button button;
    int department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText)findViewById(R.id.last_name);
        phoneNumber = (EditText)findViewById(R.id.phine_number);
        email = (EditText)findViewById(R.id.email);

        department_tv = (TextView) findViewById(R.id.department_tv);
        status_tv = (TextView)findViewById(R.id.status_tv);

        departmentSpinner = (Spinner)findViewById(R.id.department_spinner);
        statusSpinner = (Spinner)findViewById(R.id.status_spinner);

        button = (Button)findViewById(R.id.signup_button);

        spinnerSetup();
        setStatusSpinner();
        setButton();




    }

    public void spinnerSetup(){
        ArrayAdapter departmentSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_department_options, android.R.layout.simple_spinner_item);
        departmentSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        departmentSpinner.setAdapter(departmentSpinnerAdapter);

//        departmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String selection = (String)parent.getItemAtPosition(position);
//                if (!TextUtils.isEmpty(selection)){
//                    if (selection.equals(getString(R.string.department_android))){
//                        department = R.string.department_android;
//                    }else if (selection.equals(R.string.department_web)){
//                        department = R.string.department_web;
//                    }else  if (selection.equals(R.string.department_hardware)){
//                        department = R.string.department_hardware;
//                    }else {
//                        department = R.string.department_unknown;
//                    }
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                       department = R.string.department_unknown;
//            }
//        });

    }
    public void setStatusSpinner(){
        ArrayAdapter statusSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_status_options, android.R.layout.simple_spinner_item);
        statusSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        statusSpinner.setAdapter(statusSpinnerAdapter);
    }

    public void setButton(){
        button = (Button)findViewById(R.id.signup_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EncryptSignUpActivity.this, EncryptionActivity.class);
                firstName = (EditText) findViewById(R.id.first_name);
                lastName = (EditText)findViewById(R.id.last_name);
                phoneNumber = (EditText)findViewById(R.id.phine_number);
                email = (EditText)findViewById(R.id.email);

                intent.putExtra("firstName", firstName.getText().toString().trim());
                intent.putExtra("lastName", lastName.getText().toString().trim());
                intent.putExtra("phoneNumber", phoneNumber.getText().toString().trim());
                intent.putExtra("email", email.getText().toString().trim());
                intent.putExtra("department", departmentSpinner.getSelectedItem().toString().trim());
                intent.putExtra("status", statusSpinner.getSelectedItem().toString().trim());

                startActivity(intent);
            }
        });

    }

    public void getEditText1(){

        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText)findViewById(R.id.last_name);
        phoneNumber = (EditText)findViewById(R.id.phine_number);
        email = (EditText)findViewById(R.id.email);


    Intent intent = new Intent(EncryptSignUpActivity.this, EncryptionActivity.class);
    intent.putExtra("firstName", firstName.getText().toString().trim());
    intent.putExtra("lastName", lastName.getText().toString().trim());
    intent.putExtra("phoneNumber", phoneNumber.getText().toString().trim());
    intent.putExtra("email", email.getText().toString().trim());
    intent.putExtra("department", departmentSpinner.getSelectedItem().toString().trim());
    intent.putExtra("status", statusSpinner.getSelectedItem().toString().trim());
    startActivity(intent);


    }



}
