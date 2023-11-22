package com.example.decoracoesapp.View;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Context context;
    public SQLiteDatabase abrirBanco(String BD) {
        try {
            SQLiteOpenHelper dbHelper = new SQLiteOpenHelper(context, BD + ".db", null, 1) {
                @Override
                public void onCreate(SQLiteDatabase db) {
                    // Crie a tabela "produtos" se ainda não existir
                    String createTableQuery = "CREATE TABLE IF NOT EXISTS produtos (id INTEGER PRIMARY KEY, nome TEXT, valor REAL)";
                    db.execSQL(createTableQuery);

                    // Adicione os produtos ao banco de dados com os valores correspondentes
                    String[] produtos = {"Mesa central", "Mesa P", "Mesa G", "Capa de Cadeira", "Balões", "Tampão", "Cortinas", "Toalha de mesa", "Bolo", "Flores", "Painel", "Vaso P", "Vaso G", "Cilindro", "Suporte Doce", "Suporte cortina", "Bandejas"};
                    double[] valores = {10.0, 3.0, 5.0, 2.5, 4.0, 7.0, 7.0, 3.0, 10.0, 3.0, 15.0, 5.0, 10.0, 5.0, 3.0, 5.0, 5.0};
                    for (int i = 0; i < produtos.length; i++) {
                        ContentValues values = new ContentValues();
                        values.put("nome", produtos[i]);
                        values.put("valor", valores[i]);
                        db.insert("produtos", null, values);
                    }
                }

                @Override
                public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                }
            };

            return dbHelper.getWritableDatabase();
        } catch (android.database.SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
