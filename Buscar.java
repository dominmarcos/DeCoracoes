package com.example.decoracoesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Buscar extends AppCompatActivity {
Button btInicio, btBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        btInicio = findViewById(R.id.btInicio);
        btBuscar = findViewById(R.id.btbuscar);




        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreMain();
            }
        });
    }
    private void abreMain() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    }
