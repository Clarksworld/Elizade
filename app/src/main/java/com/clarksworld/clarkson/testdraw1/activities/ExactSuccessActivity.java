package com.clarksworld.clarkson.testdraw1.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.clarksworld.clarkson.testdraw1.R;

/**
 * Created by CLARKSWORLD on 05/05/2018.
 */

public class ExactSuccessActivity extends AppCompatActivity {

    ImageView successImage;
    TextView successText;
    Button successButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exeact_success_layout);

        successImage =  findViewById(R.id.success_image);
        successText = findViewById(R.id.success_tv);
        successButton = findViewById(R.id.success_button);
    }
}
