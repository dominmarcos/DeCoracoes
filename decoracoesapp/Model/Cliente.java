package com.example.decoracoesapp.Model;

public class Cliente {
    int id;
    String nome;
    String telefone;

    public Cliente(){}

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return "ID: " + this.id + " Nome: " + this.nome + " Telefone: " + this.telefone + "\n";
    }

    public String[] toTabela() {
        return new String[]{this.id+"", this.nome, this.telefone};
    }
}


