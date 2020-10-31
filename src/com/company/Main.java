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

        try(BufferedReader leitor = new BufferedReader (new FileReader(caminho))){
            String linha = leitor.readLine();
            linha = leitor.readLine();

            while(leitor.readLine() != null) {
                    linha = linha.replaceAll(":",",");

                    String info[] = linha.split(" ");
                    Integer codigoPiloto = Integer.parseInt(info[1]);
                    String nomePiloto = info[3];
                    Integer numeroVolta = Integer.parseInt(info[4]);
                    Double tempoVolta = FormatarTempo(info[5]);

                    Piloto piloto = new Piloto(codigoPiloto, nomePiloto, numeroVolta, tempoVolta);
                    lista.add(piloto);

                    linha = leitor.readLine();

            }
            for (Piloto p : lista){
                System.out.println(p);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    static Double FormatarTempo (String info){
        String tempo[] = info.split(",");
        Integer min = Integer.parseInt(tempo[0])*60;
        Double seg = Double.parseDouble(tempo[1]);

        return min+seg;
    }
}