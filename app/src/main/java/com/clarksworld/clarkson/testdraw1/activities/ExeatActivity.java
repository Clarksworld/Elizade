package com.clarksworld.clarkson.testdraw1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.clarksworld.clarkson.testdraw1.R;

/**
 * Created by CLARKSWORLD on 13/05/2018.
 */

public class ExeatActivity extends AppCompatActivity {


    ImageView exeatImage, exeatInfoImage;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_exeat);

        exeatImage = findViewById(R.id.exeat_image);
        exeatInfoImage = findViewById(R.id.exeat_info_image);
        floatingActionButton = findViewById(R.id.fab_btn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExeatActivity.this, ExeatDetailActivity.class);
                startActivity(intent);
            }
        });
    }

public void gettingQrImage(){


    exeatImage = findViewById(R.id.exeat_image);
    exeatInfoImage = findViewById(R.id.exeat_info_image);

    Intent intent = getIntent();
    String newsImage = intent.getStringExtra("image");
   exeatInfoImage.setImageResource(Integer.parseInt(newsImage));


}
}
