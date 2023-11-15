package com.example.decoracoesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btcadastrar, btbuscar;
    Cliente cliente = new Cliente();
    public SQLiteDatabase abrirbanco(String BD) {
        try {
            SQLiteDatabase bdapp = openOrCreateDatabase(BD + ".db", Context.MODE_PRIVATE, null);
            return bdapp;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void createtable() {
        try {
            SQLiteDatabase bd = abrirbanco("BDECORACOES");
            String SQL = "CREATE TABLE IF NOT EXISTS cliente(" +
                    "id integer, nome varchar (40), telefone numeric)";
            bd.execSQL(SQL);
            bd.close();
        } catch (SQLException ex) {

        }
    }

    public void insert(Cliente cliente) {
        try {
            SQLiteDatabase bd = abrirbanco("BDECORACOES");
            // insert into aluno values (id, 'nome')"
            String SQL = "INSERT INTO cliente values(" + cliente.getId() + ",'" + cliente.getNome() + ",'" + cliente.getTelefone() + "')";
            bd.execSQL(SQL);
            bd.close();
        } catch (SQLException ex) {

        }
    }



    public String select() {
        String aux = "";
        String acumulador = "";
        try {
            SQLiteDatabase bd = abrirbanco("BDECORACOES");
            Cursor c = bd.rawQuery("select * from cliente", null);
            while (c.moveToNext()) {
                aux = c.getInt(0) + c.getString(1);
                acumulador += aux + "\n";
            }
        } catch (SQLException ex) {
        }
        return acumulador;
    }


    public Boolean select(Cliente cliente) {
        String nome="";
        String telefone="";
        String id="";
        try {
            SQLiteDatabase bd = abrirbanco("BDECORACOES");
            Cursor c = bd.rawQuery("select * from cliente", null);
            while (c.moveToNext()) {
                if(nome.equals(cliente.getNome()) && id.equals(cliente.getId())
                        || telefone.equals(cliente.getTelefone()) && nome.equals(cliente.getNome())){
                    return true;
                }
            }
        } catch (SQLException ex) {
            Toast.makeText(this, "USUARIO NÃO CADASTRADO!", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

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


