package com.example.ana.volunteerwork.database;

/**
 * Created by gabri on 04/12/2017.
 */

public class Evento {
    String nome,descricao, datIni, datFim, horaIni, horaFim, endereco;

    public Evento() {
    }

    public Evento(String nome, String organizador, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
