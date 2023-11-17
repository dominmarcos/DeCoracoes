package com.example.decoracoesapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.decoracoesapp.Model.Cliente;
import com.example.decoracoesapp.R;
import com.example.decoracoesapp.View.Buscar;
import com.example.decoracoesapp.View.Cadastrar;


public class MainActivity extends AppCompatActivity {
    Button btcadastrar, btbuscar;

    Cliente cliente = new Cliente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btcadastrar = findViewById(R.id.btcadastrar);
        btbuscar = findViewById(R.id.btbuscar);

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            abreCadastrar();
            }
        });

        btbuscar = findViewById(R.id.btbuscar);

        btbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreBuscar();
            }
        });

    }
    private void abreCadastrar() {
        Intent intent = new Intent(this, Cadastrar.class);
        startActivity(intent);
        finish();
    }

    private void abreBuscar() {
        Intent intent = new Intent(this, Buscar.class);
        startActivity(intent);
        finish();
    }


    }


