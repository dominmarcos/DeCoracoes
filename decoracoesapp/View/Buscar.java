package com.example.decoracoesapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.decoracoesapp.R;

public class Buscar extends AppCompatActivity {
Button btInicio, btBuscar, btAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        btInicio = findViewById(R.id.btInicioAlterado);
        btBuscar = findViewById(R.id.btbuscar);
        btAlterar = findViewById(R.id.btAlterar);



btAlterar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        abreAlteracao();
    }
});

        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreMain();
            }
        });
    }
    private void abreMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void abreAlteracao() {
        Intent intent = new Intent(this, Alteracao.class);
        startActivity(intent);
        finish();
    }

    }
