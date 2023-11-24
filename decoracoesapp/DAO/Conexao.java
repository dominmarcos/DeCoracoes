package com.example.decoracoesapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {



    // Deixa o construtor privado para não instanciar essa classe.
    private Conexao() {}

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/decoracoesapp", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
