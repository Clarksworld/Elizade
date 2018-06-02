package com.clarksworld.clarkson.testdraw1.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.clarksworld.clarkson.testdraw1.BaseActivity;
import com.clarksworld.clarkson.testdraw1.R;

/**
 * Created by CLARKSWORLD on 11/05/2018.
 */

public class ExeactNotificationActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exeat_notification_layout);
        dialogSetUp();

    }



    public void dialogSetUp(){


        final CharSequence[] items = {"notification message", "Continue to login page", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ExeactNotificationActivity.this);
        builder.setTitle("Notification Message");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (items[which].equals("notification message")) {
                    notifyStudent();

                } else if (items[which].equals("Continue to login page")) {

                    Intent intent = new Intent(ExeactNotificationActivity.this, SignInActivity.class);
                    startActivity(intent);


                } else if (items[which].equals("Cancel")) {
                    Intent intent = new Intent(ExeactNotificationActivity.this, BaseActivity.class);
                    startActivity(intent);


                }

            }
        });
        builder.show();
    }

    public void notifyStudent(){

        imageView = findViewById(R.id.exeact_notification_image);
        textView  =findViewById(R.id.notify_text);
        button = findViewById(R.id.notify_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExeactNotificationActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }

}
