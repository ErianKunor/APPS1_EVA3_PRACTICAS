package com.example.eva3_7_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtvwMensa;
    Handler miHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int valor_i = (int)msg.obj;
            txtvwMensa.append("Hilo: "+msg.what+"valor de i = "+valor_i+"\n");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtvwMensa = findViewById(R.id.txtvwMensa);

        Thread tHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = miHandler.obtainMessage(1000, i);
                    miHandler.sendMessage(msg);
                    Log.wtf("MiRunnable",i+"");
                    i++;
                }
            }
        };

        tHilo.start();

    }
}
