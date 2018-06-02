package com.clarksworld.clarkson.testdraw1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.clarksworld.clarkson.testdraw1.BaseActivity;
import com.clarksworld.clarkson.testdraw1.R;

/**
 * Created by CLARKSWORLD on 06/05/2018.
 */

public class EditProfileActivity extends AppCompatActivity {
    EditText name, matNumber, faculty, department, level, email;
    Button saveData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        name = findViewById(R.id.edit_name);
        matNumber = findViewById(R.id.edit_mat_number);
        faculty = findViewById(R.id.edit_faculty);
        department = findViewById(R.id.edit_department);
        level = findViewById(R.id.edit_level);
        email  = findViewById(R.id.edit_email);

        saveData = findViewById(R.id.save_tbn);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detals();

            }
        });


    }

    public void detals(){

        Intent intent = new Intent(EditProfileActivity.this, BaseActivity.class);

        name = findViewById(R.id.edit_name);
        matNumber = findViewById(R.id.edit_mat_number);
        faculty = findViewById(R.id.edit_faculty);
        department = findViewById(R.id.edit_department);
        level = findViewById(R.id.edit_level);
        email  = findViewById(R.id.edit_email);

        intent.putExtra("name",name.getText().toString().trim());
        intent.putExtra("matNumber",matNumber.getText().toString().trim());
        intent.putExtra("faculty",faculty.getText().toString().trim());
        intent.putExtra("department",department.getText().toString().trim());
        intent.putExtra("level",level.getText().toString().trim());
        intent.putExtra("email",email.getText().toString().trim());
        startActivity(intent);







    }
}
