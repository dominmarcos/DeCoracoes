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

    private void cadastrarFesta() {
        String nome = nometxt.getText().toString();
        String telefone = edittextPhone.getText().toString();
        String data = editTextDate.getText().toString();
        String local = EditTextEndereco.getText().toString();

        // Crie um objeto Cliente com as informações do nome e telefone do cliente
        Cliente cliente = new Cliente(nome, telefone);

        // Salve o cliente no banco de dados
        SQLiteDatabase db = SeuDatabaseHelper.getInstance(this).getWritableDatabase();
        ContentValues valuesCliente = new ContentValues();
        valuesCliente.put("nome", cliente.getNome());
        valuesCliente.put("telefone", cliente.getTelefone());
        long clienteId = db.insert("clientes", null, valuesCliente);

        // Crie um objeto Evento com as informações da data da festa e local da festa
        Evento evento = new Evento(local, data);

        // Salve o evento no banco de dados
        ContentValues valuesEvento = new ContentValues();
        valuesEvento.put("local", evento.getLocal());
        valuesEvento.put("data", evento.getData().getTime());
        long eventoId = db.insert("eventos", null, valuesEvento);

        // Verifique quais produtos foram selecionados
        if (checkboxProduto1.isChecked()) {
            ContentValues valuesProduto1 = new ContentValues();
            valuesProduto1.put("nome", "Mesa central");
            valuesProduto1.put("quantidade", 10);
            valuesProduto1.put("evento_id", eventoId);
            db.insert("produtos", null, valuesProduto1);
        }

        if (checkboxProduto2.isChecked()) {
            ContentValues valuesProduto2 = new ContentValues();
            valuesProduto2.put("nome", "Mesa P");
            valuesProduto2.put("quantidade", 3);
            valuesProduto2.put("evento_id", eventoId);
            db.insert("produtos", null, valuesProduto2);
        }

        if (checkboxProduto3.isChecked()) {
            ContentValues valuesProduto3 = new ContentValues();
            valuesProduto3.put("nome", "Mesa G");
            valuesProduto3.put("quantidade", 5);
            valuesProduto3.put("evento_id", eventoId);
            db.insert("produtos", null, valuesProduto3);
        }

        // Limpe os campos de texto
        nomeCliente.setText("");
        telefoneCliente.setText("");
        dataFesta.setText("");
        localFesta.setText("");

        // Implemente o restante da lógica para cadastrar a festa com as informações necessárias
    }


    private void abreMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

