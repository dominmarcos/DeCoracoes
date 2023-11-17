package com.example.decoracoesapp.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Context context;

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/decoracoesapp", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Conexao() {}

    public SQLiteDatabase abrirBanco(String BD) {
        try {
            SQLiteOpenHelper dbHelper = new SQLiteOpenHelper(context, BD + ".db", null, 1) {
                @Override
                public void onCreate(SQLiteDatabase db) {
                    // Código de criação de tabelas, se necessário
                }

                @Override
                public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                    // Código de atualização do banco de dados, se necessário
                }
            };

            return dbHelper.getWritableDatabase();
        } catch (android.database.SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
