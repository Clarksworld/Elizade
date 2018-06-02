package com.clarksworld.clarkson.testdraw1.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.clarksworld.clarkson.testdraw1.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by CLARKSWORLD on 07/05/2018.
 */

public class DecryptionActivity extends AppCompatActivity {

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void scanCode(View view){
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZxingScannerResultHandler());
        setContentView(scannerView);
        scannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    class ZxingScannerResultHandler implements  ZXingScannerView.ResultHandler{

        @Override
        public void handleResult(Result result) {
            String resultCode = result.getText();
            Toast.makeText(DecryptionActivity.this, resultCode, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            scannerView.stopCamera();
        }
    }
}
