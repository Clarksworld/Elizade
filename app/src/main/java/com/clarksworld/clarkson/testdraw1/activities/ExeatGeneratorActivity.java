package com.clarksworld.clarkson.testdraw1.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.clarksworld.clarkson.testdraw1.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

/**
 * Created by CLARKSWORLD on 08/05/2018.
 */

public  class ExeatGeneratorActivity  extends AppCompatActivity{


    TextView genName, genMatNumber, genDepartment, genPhoneNumber, genDestination, genPurpose, genParent;

    ImageView genImage;
    Button genButton;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.exeact_generator_layout);

        getSetup();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveQrImage();


            }
        });

    }

    public void getSetup(){


        genName = findViewById(R.id.gen_name);
        genMatNumber = findViewById(R.id.gen_matnumber);
        genDepartment = findViewById(R.id.gen_department);
        genPhoneNumber = findViewById(R.id.gen_phonenumber);
        genDestination = findViewById(R.id.gen_destination);
        genPurpose = findViewById(R.id.gen_purpose);
        genParent = findViewById(R.id.gen_guardian);
        Intent parseIntent = getIntent();

        String name = parseIntent.getStringExtra("name");
        final String matricNumber = parseIntent.getStringExtra("matricNumber");
        String department  = parseIntent.getStringExtra("department");
        String phoneNumber = parseIntent.getStringExtra("phoneNumber");
        String destination = parseIntent.getStringExtra("destination");
        String purpose = parseIntent.getStringExtra("purpose");
        String parent = parseIntent.getStringExtra("parent");

        genName.setText(name);
        genMatNumber.setText(matricNumber);
        genDepartment.setText(department);
        genPhoneNumber.setText(phoneNumber);
        genDestination.setText(destination);
        genPurpose.setText(purpose);
        genParent.setText(parent);
        genImage = findViewById(R.id.gen_image);
        genButton  = findViewById(R.id.gen_button);
        genButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode
                            (matricNumber.toString(), BarcodeFormat.QR_CODE,200,200 );
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    genImage.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });


    }

    public  void saveQrImage(){
        Intent intent = new Intent(ExeatGeneratorActivity.this, ExeatActivity.class);
        intent.putExtra("image", (Parcelable) genImage);
        startActivity(intent);
    }
}
