package com.example.qrscanner;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class ScanQR extends AppCompatActivity {

    Button scan_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        scan_code=findViewById(R.id.scan1);
        scan_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanCode();
            }

        });

    }
    private void scanCode() {
        ScanOptions options=new ScanOptions();
        options.setPrompt("volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLauncher=registerForActivityResult(new ScanContract(),result ->{
        AlertDialog.Builder builder=new AlertDialog.Builder(ScanQR.this);
        builder.setTitle("Result");
        builder.setMessage(result.getContents());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    });
}