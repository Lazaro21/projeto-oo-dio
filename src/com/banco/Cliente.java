package com.banco;

public class Cliente {
    private String nome;
    private int score;

    public int getScore() {
        return score;
    }

    public Cliente(String nome, int score) {
        this.nome = nome;
        this.score = score;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente: " + getNome();
    }
}
