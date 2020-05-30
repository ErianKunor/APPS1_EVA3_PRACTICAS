package com.example.eva3_8_handler_runnables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtvwMensa;
    Handler miHandler = new Handler();
    int i;


    Runnable bgRun = new Runnable() {
        @Override
        public void run() {
            i = 0;
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                miHandler.post(fgRun);
                Log.wtf("MiRunnable",i+"");
                i++;
            }
        }
    };

    Runnable fgRun = new Runnable() {
        @Override
        public void run() {
        txtvwMensa.append("valor de i = "+ i +"\n");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtvwMensa = findViewById(R.id.txtvwMensa);

        Thread tHilo = new Thread(bgRun);
        tHilo.start();

    }
}
