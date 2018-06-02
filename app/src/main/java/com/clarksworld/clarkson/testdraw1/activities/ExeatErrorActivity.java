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

public class ExeatErrorActivity extends AppCompatActivity {

    ImageView errorImage;
    TextView fialedText;
    Button fieledButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exeat_filled_layout);
        errorImage = findViewById(R.id.error_image);
        fialedText  = findViewById(R.id.fialed_tv);
        fieledButton = findViewById(R.id.failed_button);

    }
}
