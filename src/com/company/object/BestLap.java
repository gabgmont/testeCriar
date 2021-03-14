package com.company.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestLap {

    public BestLap(String name, Double lapTime) {
        this.name = name;
        this.lapTime = lapTime;
    }

    private String name;
    private Double lapTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLapTime() {
        return lapTime;
    }

    public void setLapTime(Double lapTime) {
        this.lapTime = lapTime;
    }

    public static List<BestLap> getPilotBestLapList(List<Lap> list, List pilotIdList) {
        String name = "";
        Double lapTime = 0.0;
        List<BestLap> bestLapList = new ArrayList<>();
        Collections.sort(list);

        for (int i = 0; i < pilotIdList.size(); i++) {

            for (Lap p : list) {
                if (p.getCode() == pilotIdList.toArray()[i]) {
                    name = p.getName();
                    lapTime = p.getLapTime();
                    BestLap bestLap = new BestLap(name, lapTime);
                    bestLapList.add(bestLap);
                    break;
                }
            }
        }
        return bestLapList;
    }

    public static Object getRaceBestLap(List<Lap> list) {
        Collections.sort(list);
        return list.get(0);
    }

    @Override
    public String toString() {
        return "BestLap{Nome do Piloto = " + name +
                ", Tempo da volta = " + lapTime +
                "}+\n";
    }
}
