package com.example.eva3_10_imagen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgvwImg;
    Bitmap imag;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            imgvwImg.setImageBitmap(imag);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgvwImg = findViewById(R.id.imgVwImg);

        Thread tHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                imag = cargarImagen("https://w.wallhaven.cc/full/xl/wallhaven-xl2qgo.jpg");
                Message msg = handler.obtainMessage();
                handler.sendMessage(msg);
            }
        };

        tHilo.start();

    }

    public Bitmap cargarImagen(String url){
        try {
            InputStream inputStream = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
