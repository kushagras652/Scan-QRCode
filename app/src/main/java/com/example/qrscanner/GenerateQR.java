package com.example.qrscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateQR extends AppCompatActivity {

    TextView qrCode;
    Button generate;
    ImageView qrCode1;
    TextInputEditText dataEdt;
   //private QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);

        qrCode=findViewById(R.id.text4);
        generate=findViewById(R.id.create);
        qrCode1=findViewById(R.id.image3);
        dataEdt=findViewById(R.id.edit1);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=dataEdt.getText().toString();
                if(data.isEmpty()){
                    Toast.makeText(GenerateQR.this, "Please enter text to generate QR...", Toast.LENGTH_SHORT).show();
                }
                else{
//                    WindowManager manager=(WindowManager) getSystemService(WINDOW_SERVICE);
//                    Display display=manager.getDefaultDisplay();
//                    Point point=new Point();
//                    display.getSize(point);
//                    int width=point.x;
//                    int height=point.y;
//                    int dimen=width<height?width:height;
//                    dimen=dimen*3/4;
                    MultiFormatWriter writer=new MultiFormatWriter();
                    try{
                        BitMatrix matrix=writer.encode(data, BarcodeFormat.QR_CODE,400,400);
                        BarcodeEncoder encoder=new BarcodeEncoder();
                        Bitmap bitmap=encoder.createBitmap(matrix);
                        qrCode.setVisibility(View.GONE);
                        qrCode1.setImageBitmap(bitmap);
                    }catch(WriterException e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}