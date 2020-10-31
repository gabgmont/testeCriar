package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    List<Piloto> lista = new ArrayList<>();

        String caminho = "C:\\Users\\gabgm\\OneDrive\\Documentos\\Gabriel\\arquivos\\log.txt";

        try(BufferedReader leitor = new BufferedReader (new FileReader(caminho))){
            String linha = leitor.readLine();
            linha = leitor.readLine();

            NumberFormat nf = new DecimalFormat("##,##.##");

            while(leitor.readLine() != null) {
                try {
                    linha = linha.replaceAll(":",",");

                    String info[] = linha.split(" ");
                    Integer codigoPiloto = Integer.parseInt(info[1]);
                    String nomePiloto = info[3];
                    Integer numeroVolta = Integer.parseInt(info[4]);
                    Double tempoVolta = nf.parse(info[5]).doubleValue();

                    Piloto piloto = new Piloto(codigoPiloto, nomePiloto, numeroVolta, tempoVolta);
                    lista.add(piloto);

                    linha = leitor.readLine();

                } catch (ParseException e) {
                    System.out.println(e.getErrorOffset());
                }
            }
            for (Piloto p : lista){
                System.out.println(p);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
