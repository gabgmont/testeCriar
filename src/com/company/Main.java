package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Piloto> lista = new ArrayList<>();

        String caminho = "C:\\Users\\gabgm\\OneDrive\\Documentos\\Gabriel\\arquivos\\log.txt";

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String linha = leitor.readLine();
            linha = leitor.readLine();

            while (linha != null) {
                linha = linha.replaceAll(":", ",");

                String info[] = linha.split(" ");
                Integer codigoPiloto = Integer.parseInt(info[1]);
                String nomePiloto = info[3];
                Integer numeroVolta = Integer.parseInt(info[4]);
                Double tempoVolta = FormatarTempo(info[5]);

                Piloto piloto = new Piloto(codigoPiloto, nomePiloto, numeroVolta, tempoVolta);
                lista.add(piloto);

                linha = leitor.readLine();
            }

            CalculoVolta(lista);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static Double FormatarTempo(String info) {
        String tempo[] = info.split(",");
        Integer min = Integer.parseInt(tempo[0]) * 60;
        Double seg = Double.parseDouble(tempo[1]);

        return min + seg;
    }

    static void CalculoVolta(List<Piloto> lista) {
        List idPiloto = new ArrayList();
        for(Piloto p : lista){
            if(!idPiloto.contains(p.getCodigo())){
                idPiloto.add(p.getCodigo());
            }
        }
        System.out.println(idPiloto);

            Double tempoTotal = 0.0;
        for (int i=0; i < idPiloto.size(); i++) {
            tempoTotal = 0.0;
            for(Piloto p : lista){
                if (p.getCodigo() == idPiloto.toArray()[i]) {
                    System.out.println(p);
                    tempoTotal = tempoTotal + p.getTempoVolta();
                }
            }System.out.println(tempoTotal);
        }
   }
}