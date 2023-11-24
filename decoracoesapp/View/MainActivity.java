package com.example.decoracoesapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.decoracoesapp.DAO.GeralDAO;
import com.example.decoracoesapp.Model.Cliente;
import com.example.decoracoesapp.Model.Evento;
import com.example.decoracoesapp.R;
import com.example.decoracoesapp.View.Buscar;
import com.example.decoracoesapp.View.Cadastrar;


public class MainActivity extends AppCompatActivity {
    Button btcadastrar, btbuscar;
    EditText buscartxt;
    GeralDAO dao = new GeralDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btcadastrar = findViewById(R.id.btcadastrar);
        btbuscar = findViewById(R.id.btbuscar);
        buscartxt = findViewById(R.id.buscartxt);

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
                String idText = buscartxt.getText().toString();
                int id = Integer.parseInt(idText);
                //if(buscartxt.getText().toString().equals(dao.procurar(buscartxt.getText().toString()))){
                if(id != -1){
                    abreBuscar(id);
                }

            }
        });

    }
    private void abreCadastrar() {
        Intent intent = new Intent(this, Cadastrar.class);
        startActivity(intent);
        finish();
    }

    private void abreBuscar(int id) {
        Intent intent = new Intent(this, Buscar.class);
        GeralDAO dao = new GeralDAO();
        Evento e = dao.procurarId(id);
        startActivity(intent);
        finish();
    }


    }


