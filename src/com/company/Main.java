package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static DecimalFormat df = new DecimalFormat("##,##0.00");

    public static void main(String[] args) {
        List<Volta> listaVolta = new ArrayList<>();
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
                Double velocidadeVolta = Double.parseDouble(info[6].replaceAll(",", "."));

                Volta volta = new Volta(codigoPiloto, nomePiloto, numeroVolta, tempoVolta, velocidadeVolta);
                listaVolta.add(volta);

                linha = leitor.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Criando lista com o código de cada piloto.
        try {
            List idPiloto = new ArrayList();
            for(Volta p : listaVolta){
                if(!idPiloto.contains(p.getCodigo())){
                    idPiloto.add(p.getCodigo());
                }
            }

            //Resultado de cada piloto
            for (int i=0; i < idPiloto.size(); i++) {
               Resultado resultado = CalculoResultado(listaVolta, idPiloto, i);
               listaResultado.add(resultado);
            }
            Collections.sort(listaResultado);

            //Definindo a posição de cada piloto
            for(int i=0; i < listaResultado.size(); i++){
                listaResultado.get(i).setPosicaoPiloto(i+1);
            }
            System.out.println("\nDesempenho dos pilotos na corrida: \n" + listaResultado);
            System.out.println("___________________________________________________________");
            System.out.println("\nA melhor volta da corrida foi: \n" + MelhorVoltaCorrida(listaVolta) );
            System.out.println("___________________________________________________________\n");

            //Achando a melhor volta de cada piloto
            for (int i=0; i < idPiloto.size(); i++) {
                System.out.println(MelhorVoltaPiloto(listaVolta, idPiloto, i));
            }
            System.out.println("\n___________________________________________________________\n");

            //Velocidade média de cada piloto
            for (int i=0; i < idPiloto.size(); i++) {
                System.out.println(VelocidadeMedia(listaVolta, idPiloto, i));
            }
            System.out.println("\n___________________________________________________________\n");

            //Diferença entre o tempo do primeiro para os demais pilotos.
            DiferencaTempo(listaResultado);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    static Double FormatarTempo(String info) {
        String tempo[] = info.split(",");
        Integer min = Integer.parseInt(tempo[0]) * 60;
        Double seg = Double.parseDouble(tempo[1]);

        return min + seg;
    }
    static Resultado CalculoResultado(List<Volta> lista, List codigos, int i) {
        double tempoTotal;
        tempoTotal = 0.0;
        Volta volta = null;

        for(Volta p : lista){
            if (p.getCodigo() == codigos.toArray()[i]) {
                tempoTotal = tempoTotal + p.getTempoVolta();
                volta = p;
            }
        }
        df.format(tempoTotal);
        assert volta != null;
        return new Resultado(volta.getCodigo(), volta.getNome(), volta.getNumeroVolta(), tempoTotal);
        }

    static String VelocidadeMedia (List<Volta> lista, List codigos, int i) {
        String nome = "";
        int numeroVoltas = 0;
        double velMedia = 0.0;

        for(Volta p : lista){
            if (p.getCodigo() == codigos.toArray()[i]) {
                velMedia = velMedia + p.getVelocidadeVolta();
                nome = p.getNome();
                numeroVoltas++;
            }
        }
        return "A velocidade média do piloto " + nome + " foi: " + df.format(velMedia/numeroVoltas);
    }

    static Object MelhorVoltaCorrida(List<Volta> lista){
        Collections.sort(lista);
        return lista.get(0);
    }

    static String MelhorVoltaPiloto (List<Volta> lista, List codigos, int i) {
        String nome = "";
        Double tempoVolta = 0.0;
        Collections.sort(lista);

        for(Volta p : lista){
            if (p.getCodigo() == codigos.toArray()[i]) {
                nome = p.getNome();
                tempoVolta = p.getTempoVolta();
                break;
            }
        }
        return "Melhor volta do Piloto: " + nome + " foi com o tempo de: " + df.format(tempoVolta) + "s";
    }

    static void DiferencaTempo (List<Resultado> lista){
        Collections.sort(lista);
        double diferenca;
        double auxiliar = 0.0;

        for(Resultado r : lista){
            if(auxiliar == 0){
                auxiliar = r.getTempoProva();
                System.out.println("Primeiro Lugar: " + r.getNomePiloto());
            }else{
                diferenca = r.getTempoProva() - auxiliar;
                System.out.println("Diferença do piloto " + r.getNomePiloto() + " foi de " + df.format(diferenca)+" segundos para o primeiro lugar.");
            }
        }
    }
}