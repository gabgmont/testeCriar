package com.company.main;

import com.company.TreatmentFile;
import com.company.object.AverageSpeed;
import com.company.object.BestLap;
import com.company.object.Lap;
import com.company.object.PilotResult;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String path = "C:\\Users\\gabgm\\IdeaProjects\\testeCriar\\log.txt";

        List<Lap> lapList = TreatmentFile.readFile(path);

//        Criando lista com o código de cada piloto.
        List pilotIdList = TreatmentFile.createIdList(lapList);

//        Resultado de cada piloto
        List<PilotResult> pilotResults = PilotResult.getResultList(lapList, pilotIdList);

//        Melhor volta de cada piloto
        List<BestLap> pilotBestLaps = BestLap.getPilotBestLapList(lapList, pilotIdList);

//        Melhor volta da corrida
        Object raceBestLap = BestLap.getRaceBestLap(lapList);

//        Velocidade média dos pilotos
        List<AverageSpeed> averageSpeedList = AverageSpeed.getAverageSpeedList(lapList, pilotIdList);


        System.out.println("\nDesempenho dos pilotos na corrida: \n" + pilotResults);
        System.out.println("___________________________________________________________");
        System.out.println("\nA melhor volta da corrida foi: \n" + raceBestLap);
        System.out.println("___________________________________________________________\n");
        System.out.println("\nPilotos e suas melhores voltas: \n" + pilotBestLaps);
        System.out.println("\n___________________________________________________________\n");
        System.out.println("\nPilotos e suas velocidades médias: \n" + averageSpeedList);
        System.out.println("\n___________________________________________________________\n");

        //Diferença entre o tempo do primeiro para os demais pilotos.
        PilotResult.timeRange(pilotResults);
    }
}