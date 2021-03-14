package com.company.object;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PilotResult implements Comparable<PilotResult> {
    private Integer codigoPiloto;
    private String nomePiloto;
    private Integer posicaoPiloto;
    private Integer numeroVoltas;
    private Double tempoProva;

    public PilotResult(Integer codigoPiloto, String nomePiloto, Integer numeroVoltas, Double tempoProva) {
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

    @Override
    public int compareTo(PilotResult o) {
        if (this.tempoProva < o.getTempoProva() && this.numeroVoltas >= o.getNumeroVoltas()) {
            return -1;
        } else if (this.tempoProva > o.getTempoProva() && this.numeroVoltas < o.getNumeroVoltas()) {
            return 1;
        }
        return 0;
    }

    public static List<PilotResult> getResultList(List<Lap> lista, List pilotIdList) {
        List<PilotResult> listaPilotResult = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("##,##0.00");

        for (int j = 0; j < pilotIdList.size(); j++) {
            double tempoTotal;
            tempoTotal = 0.0;
            Lap volta = null;

            for (Lap p : lista) {
                if (p.getCode() == pilotIdList.toArray()[j]) {
                    tempoTotal = tempoTotal + p.getLapTime();
                    volta = p;
                }
            }
            df.format(tempoTotal);
            assert volta != null;
            PilotResult pilotResult = new PilotResult(volta.getCode(),
                    volta.getName(), volta.getLapNumber(), tempoTotal);

            listaPilotResult.add(pilotResult);
        }

        Collections.sort(listaPilotResult);

//        Definindo a posição de cada piloto
        for (int i = 0; i < listaPilotResult.size(); i++) {
            listaPilotResult.get(i).setPosicaoPiloto(i + 1);
        }
        return listaPilotResult;
    }

    public static void timeRange(List<PilotResult> lista) {
        DecimalFormat df = new DecimalFormat("##,##0.00");

        Collections.sort(lista);
        double diferenca;
        double auxiliar = 0.0;

        for (PilotResult r : lista) {
            if (auxiliar == 0) {
                auxiliar = r.getTempoProva();
                System.out.println("Primeiro Lugar: " + r.getNomePiloto());
            } else {
                diferenca = r.getTempoProva() - auxiliar;
                System.out.println("Diferença do piloto "
                        + r.getNomePiloto() + " foi de "
                        + df.format(diferenca)
                        + " segundos para o primeiro lugar.");
            }
        }
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "Codigo do Piloto = " + codigoPiloto +
                ", Nome do Piloto = '" + nomePiloto + '\'' +
                ", Posicao do Piloto = " + posicaoPiloto +
                ", Numero de Voltas = " + numeroVoltas +
                ", Tempo de Prova = " + tempoProva + "s" +
                "}\n";
    }
}

