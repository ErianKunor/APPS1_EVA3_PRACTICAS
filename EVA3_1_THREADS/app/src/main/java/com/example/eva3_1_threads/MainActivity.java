package com.example.eva3_1_threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EJEMPLO COMO UNA CONEXCIÓN A BASE DE DATOS

        //10 segundos
        for (int i=0; i<10; i++){
            try {
                Thread.sleep(1000); //<- 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
