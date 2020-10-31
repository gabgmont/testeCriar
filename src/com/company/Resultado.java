package com.company;

public class Resultado {
    private Integer codigoPiloto;
    private String nomePiloto;
    private Integer posicaoPiloto;
    private Integer numeroVoltas;
    private Double tempoProva;

    public Resultado(Integer codigoPiloto, String nomePiloto, Integer posicaoPiloto, Integer numeroVoltas, Double tempoProva) {
        this.codigoPiloto = codigoPiloto;
        this.nomePiloto = nomePiloto;
        this.posicaoPiloto = posicaoPiloto;
        this.numeroVoltas = numeroVoltas;
        this.tempoProva = tempoProva;
    }

    public Integer getCodigoPiloto() {
        return codigoPiloto;
    }

    public void setCodigoPiloto(Integer codigoPiloto) {
        this.codigoPiloto = codigoPiloto;
    }

    public String getNomePiloto() {
        return nomePiloto;
    }

    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }

    public Integer getPosicaoPiloto() {
        return posicaoPiloto;
    }

    public void setPosicaoPiloto(Integer posicaoPiloto) {
        this.posicaoPiloto = posicaoPiloto;
    }

    public Integer getNumeroVoltas() {
        return numeroVoltas;
    }

    public void setNumeroVoltas(Integer numeroVoltas) {
        this.numeroVoltas = numeroVoltas;
    }

    public Double getTempoProva() {
        return tempoProva;
    }

    public void setTempoProva(Double tempoProva) {
        this.tempoProva = tempoProva;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "Codigo do Piloto = " + codigoPiloto +
                ", Nome do Piloto = '" + nomePiloto + '\'' +
                ", Posicao do Piloto = " + posicaoPiloto +
                ", Numero de Voltas = " + numeroVoltas +
                ", Tempo de Prova = " + tempoProva +
                '}';
    }
}
