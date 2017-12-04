package com.example.ana.volunteerwork.database;

/**
 * Created by gabri on 04/12/2017.
 */

public class Evento {
    String nome,organizador,descricao;

    public Evento() {
    }

    public Evento(String nome, String organizador, String descricao) {
        this.nome = nome;
        this.organizador = organizador;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getOrganizador() {
        return organizador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
