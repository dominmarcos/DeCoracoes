package com.example.decoracoesapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.decoracoesapp.DAO.GeralDAO;
import com.example.decoracoesapp.Model.Cliente;
import com.example.decoracoesapp.Model.Evento;
import com.example.decoracoesapp.Model.Produto;
import com.example.decoracoesapp.R;

import java.util.Date;

public class Cadastrar extends AppCompatActivity {
    Button btMain, btcadastrarfesta;
    EditText nometxt, edittextPhone, editTextDate,EditTextEndereco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        btMain = findViewById(R.id.btMain);
        btcadastrarfesta = findViewById(R.id.btcadastrarfesta);

        btcadastrarfesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btMain.setOnClickListener(new View.OnClickListener() {
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
}

