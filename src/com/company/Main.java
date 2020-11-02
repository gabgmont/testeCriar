package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Piloto> listaPiloto = new ArrayList<>();
        List<Resultado> listaResultado = new ArrayList<>();

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
                listaPiloto.add(piloto);

                linha = leitor.readLine();
            }
            List idPiloto = new ArrayList();
            for(Piloto p : listaPiloto){
                if(!idPiloto.contains(p.getCodigo())){
                    idPiloto.add(p.getCodigo());
                }
            }
            for (int i=0; i < idPiloto.size(); i++) {
               Resultado resultado = CalculoResultado(listaPiloto, idPiloto, i);
               listaResultado.add(resultado);
            }
            Collections.sort(listaResultado);

            for(int i=0; i < listaResultado.size(); i++){
                listaResultado.get(i).setPosicaoPiloto(i+1);
            }
            System.out.println("\nDesempenho dos pilotos na corrida: \n" + listaResultado);
            System.out.println("\nA melhor volta foi: \n" + MelhorVolta(listaPiloto) ); // Bônus 1*

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
    static Resultado CalculoResultado(List<Piloto> lista, List codigos, int i) {

        Double tempoTotal;
        tempoTotal = 0.0;
        Piloto piloto = null;
        for(Piloto p : lista){
            if (p.getCodigo() == codigos.toArray()[i]) {
                tempoTotal = tempoTotal + p.getTempoVolta();
                piloto = p;
            }
        }

        Resultado resultado = new Resultado(piloto.getCodigo(), piloto.getNome(), piloto.getNumeroVolta(), tempoTotal);
        return resultado;
    }

    static Object MelhorVolta(List<Piloto> lista){

        List listaFormatada = lista;
        Collections.sort(listaFormatada);

        return listaFormatada.get(0);
    }
}