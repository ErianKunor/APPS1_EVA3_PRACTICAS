package com.example.eva3_2_threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EJEMPLO COMO UNA CONEXCIÓN A BASE DE DATOS

        //10 segundos

        /*
        for (int i=0; i<10; i++){
            try {
                Thread.sleep(1000); //<- 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        Thread th1 = new Thread(){
            @Override
            public void run() {//Trabajo en 2o plano
                super.run();

                for (int i=0; i<10; i++){
                    try {
                        Thread.sleep(1000); //<- 1 segundo
                        Log.wtf("th1",i+"");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        th1.start();//Nuevo hilo

    }
}
