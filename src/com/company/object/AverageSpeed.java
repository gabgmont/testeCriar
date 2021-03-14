package com.company.object;

import java.util.ArrayList;
import java.util.List;

public class AverageSpeed {

    private String name;
    private Double averageSpeed;

    public AverageSpeed(String name, Double averageSpeed) {
        this.name = name;
        this.averageSpeed = averageSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public static List<AverageSpeed> getAverageSpeedList(List<Lap> lista, List pilotIdList) {
        List<AverageSpeed> averageSpeedList = new ArrayList<>();

        for (int i = 0; i < pilotIdList.size(); i++) {
            String name = "";
            int numeroVoltas = 0;
            double velMedia = 0.0;

            for (Lap p : lista) {
                if (p.getCode() == pilotIdList.toArray()[i]) {
                    velMedia += p.getLapAvgSpeed();
                    name = p.getName();
                    numeroVoltas++;
                }
            }
            velMedia /= numeroVoltas;
            AverageSpeed averageSpeed = new AverageSpeed(name, velMedia);
            averageSpeedList.add(averageSpeed);
        }
        return averageSpeedList;
    }

    @Override
    public String toString() {
        return "AverageSpeed{Nome do piloto = " + name + ", Velocidade Média = " + averageSpeed +
                "}\n";
    }
}
