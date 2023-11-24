package com.example.decoracoesapp.Model;

import java.util.Date;

public class Evento {
    String local;
    Date data;



    public Evento() {
    }

    public Evento(String local, Date data) {
        this.local = local;
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
