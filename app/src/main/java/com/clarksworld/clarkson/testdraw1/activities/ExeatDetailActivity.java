package com.clarksworld.clarkson.testdraw1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.clarksworld.clarkson.testdraw1.R;

/**
 * Created by CLARKSWORLD on 08/05/2018.
 */

public class ExeatDetailActivity extends AppCompatActivity {
    EditText nameExeat, matNumberExeat, departmentExeat, phoneNumberExeat,
            destinationExeat, exeatPurposeExeat, parentExeat;
    Button exeatButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exeat_detail_layout);

        nameExeat = findViewById(R.id.exeat_name);
        matNumberExeat = findViewById(R.id.exeat_matnumber);
        departmentExeat = findViewById(R.id.exeat_department);
        phoneNumberExeat = findViewById(R.id.exeat_phonenumber);
        destinationExeat = findViewById(R.id.exeat_destination);
        exeatPurposeExeat = findViewById(R.id.exeat_purpoaeofexeat);
        parentExeat = findViewById(R.id.exeat_parent);
        exeatButton  = findViewById(R.id.exeat_button);
        setDetail();

    }

    public void setDetail(){
        exeatButton = findViewById(R.id.exeat_button);
        exeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ExeatDetailActivity.this, ExeatGeneratorActivity.class);
                nameExeat = findViewById(R.id.exeat_name);
                matNumberExeat = findViewById(R.id.exeat_matnumber);
                departmentExeat = findViewById(R.id.exeat_department);
                phoneNumberExeat = findViewById(R.id.exeat_phonenumber);
                destinationExeat = findViewById(R.id.exeat_destination);
                exeatPurposeExeat = findViewById(R.id.exeat_purpoaeofexeat);
                parentExeat = findViewById(R.id.exeat_parent);

                intent.putExtra("name", nameExeat.getText().toString().trim());
                intent.putExtra("matricNumber", matNumberExeat.getText().toString().trim());
                intent.putExtra("department", departmentExeat.getText().toString().trim());
                intent.putExtra("phoneNumber", phoneNumberExeat.getText().toString().trim());
                intent.putExtra("destination", destinationExeat.getText().toString().trim());
                intent.putExtra("purpose", exeatPurposeExeat.getText().toString().trim());
                intent.putExtra("parent", parentExeat.getText().toString().trim());
                startActivity(intent);

            }
        });
    }
}
