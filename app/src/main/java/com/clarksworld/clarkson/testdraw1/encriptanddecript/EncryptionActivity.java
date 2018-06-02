package com.clarksworld.clarkson.testdraw1.encriptanddecript;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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

public class EncryptionActivity extends AppCompatActivity {
    TextView firstName, lastName, phoneNumber, email, department, status;
    int key = 200;
    String encmsg = "";
    ImageView imageView;

    Button button;
    Intent detailIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);


        gettingText();

        imageView = (ImageView)findViewById(R.id.qr_image);



    }

    public void gettingText(){

        firstName = (TextView) findViewById(R.id.first_name_tv);
        lastName  = (TextView)findViewById(R.id.last_name_tv);
        phoneNumber = (TextView)findViewById(R.id.phone_number_tv);
        email = (TextView)findViewById(R.id.email_tv);
        department = (TextView)findViewById(R.id.department_spinner_tv);
        status = (TextView)findViewById(R.id.status_spinner_tv);

        Intent detailIntent = getIntent();
         String first_name = detailIntent.getStringExtra("firstName");
        String last_name = detailIntent.getStringExtra("lastName");
        String phone_number = detailIntent.getStringExtra("phoneNumber");
        final String e_mail = detailIntent.getStringExtra("email");
        String departmentText = detailIntent.getStringExtra("department");
        String statusText = detailIntent.getStringExtra("status");

        firstName.setText(first_name);
        lastName.setText(last_name);
        phoneNumber.setText(phone_number);
        email.setText(e_mail);
        department.setText(departmentText);
        status.setText(statusText);

//        final String DataContainer = "/" + firstName.getText().toString() + "/" + lastName.getText().toString()
//                + "/" + phoneNumber.getText().toString()
//                + "/" + email.getText().toString() + "/" + department.getText().toString() + "/" + status.getText().toString() + "*";
//
//        //Encrypt Datacontainer
//        for(int i = 0; i < DataContainer.length(); i++){
//            encmsg = encmsg + (char) (DataContainer.charAt(i) ^ key);
//        }

        imageView = (ImageView)findViewById(R.id.qr_image);
        button = (Button)findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode
                            (email.toString(), BarcodeFormat.QR_CODE,200,200 );
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    imageView.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });



    }

    public void grGenerator(){
        String e_mail = detailIntent.getStringExtra("email");
        email = (TextView)findViewById(R.id.email_tv);
        email.setText(e_mail);
        imageView = (ImageView)findViewById(R.id.qr_image);
        button = (Button)findViewById(R.id.submit_button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
               try {
                   BitMatrix bitMatrix = multiFormatWriter.encode
                           (email.toString(), BarcodeFormat.QR_CODE,200,200 );
                   BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                   Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                   imageView.setImageBitmap(bitmap);
               }
               catch (WriterException e){
                   e.printStackTrace();
               }
           }
       });


    }
}
