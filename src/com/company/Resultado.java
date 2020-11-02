package com.company;

public class Resultado implements Comparable<Resultado> {
    private Integer codigoPiloto;
    private String nomePiloto;
    private Integer posicaoPiloto;
    private Integer numeroVoltas;
    private Double tempoProva;
    private Double melhorVolta;

    public Resultado(Integer codigoPiloto, String nomePiloto, Integer numeroVoltas, Double tempoProva) {
        this.codigoPiloto = codigoPiloto;
        this.nomePiloto = nomePiloto;
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

    public Double getMelhorVolta() {
        return melhorVolta;
    }

    public void setMelhorVolta(Double melhorVolta) {
        this.melhorVolta = melhorVolta;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "Codigo do Piloto = " + codigoPiloto +
                ", Nome do Piloto = '" + nomePiloto + '\'' +
                ", Posicao do Piloto = " + posicaoPiloto +
                ", Numero de Voltas = " + numeroVoltas +
                ", Tempo de Prova = " + tempoProva +
                "}\n";
    }

    @Override
    public int compareTo(Resultado o) {
        if (this.tempoProva < o.getTempoProva() && this.numeroVoltas >= o.getNumeroVoltas()){
            return -1;
        }else if(this.tempoProva > o.getTempoProva() && this.numeroVoltas < o.getNumeroVoltas()){
            return 1;
        }
        return 0;
    }
}
