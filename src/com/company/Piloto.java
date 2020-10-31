package com.company;

import java.util.ArrayList;

public class Piloto {

    private Integer codigo;
    private String nome;
    private Integer numeroVolta;
    private Double tempoVolta;

    public Piloto(Integer codigo, String nome, Integer numeroVolta, Double tempoVolta) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroVolta = numeroVolta;
        this.tempoVolta = tempoVolta;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumeroVolta() {
        return numeroVolta;
    }

    public void setNumeroVolta(Integer numeroVolta) {
        this.numeroVolta = numeroVolta;
    }

    public Double getTempoVolta() {
        return tempoVolta;
    }

    public void setTempoVolta(Double tempoVolta) {
        this.tempoVolta = tempoVolta;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", numeroVolta=" + numeroVolta +
                ", tempoVolta=" + tempoVolta +
                '}';
    }
}
