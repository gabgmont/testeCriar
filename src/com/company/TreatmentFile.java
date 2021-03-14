package com.company;

import com.company.object.Lap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TreatmentFile {

    public static List<Lap> readFile(String path) {
        List<Lap> lapList = new ArrayList<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader(path))) {
            String linha = leitor.readLine();
            linha = leitor.readLine();

            while (linha != null) {
                linha = linha.replaceAll(":", ",");

                String[] info = linha.split(" ");
                Integer codigoPiloto = Integer.parseInt(info[1]);
                String nomePiloto = info[3];
                Integer numeroVolta = Integer.parseInt(info[4]);
                Double tempoVolta = FormatarTempo(info[5]);
                Double velocidadeVolta = Double.parseDouble(info[6].replaceAll(",", "."));

                Lap Lap = new Lap(codigoPiloto, nomePiloto, numeroVolta, tempoVolta, velocidadeVolta);
                lapList.add(Lap);

                linha = leitor.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lapList;
    }

    static Double FormatarTempo(String info) {
        String tempo[] = info.split(",");
        Integer min = Integer.parseInt(tempo[0]) * 60;
        Double seg = Double.parseDouble(tempo[1]);

        return min + seg;
    }

    public static List createIdList(List<Lap> lapList) {

        List pilotIdList = new ArrayList();
        for (Lap p : lapList) {
            if (!pilotIdList.contains(p.getCode())) {
                pilotIdList.add(p.getCode());
            }
        }
        return pilotIdList;
    }


}
