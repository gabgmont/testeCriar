package com.company.object;

public class Lap implements Comparable<Lap> {

    private Integer code;
    private String name;
    private Integer lapNumber;
    private Double lapTime;
    private Double lapAvgSpeed;

    public Lap(Integer code, String name, Integer lapNumber, Double lapTime, Double lapAvgSpeed) {
        this.code = code;
        this.name = name;
        this.lapNumber = lapNumber;
        this.lapTime = lapTime;
        this.lapAvgSpeed = lapAvgSpeed;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(Integer lapNumber) {
        this.lapNumber = lapNumber;
    }

    public Double getLapTime() {
        return lapTime;
    }

    public void setLapTime(Double lapTime) {
        this.lapTime = lapTime;
    }

    public Double getLapAvgSpeed() {
        return lapAvgSpeed;
    }

    public void setLapAvgSpeed(Double lapAvgSpeed) {
        this.lapAvgSpeed = lapAvgSpeed;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "Codigo do Piloto = " + code +
                ", Nome do Piloto = '" + name + '\'' +
                ", Numero da Volta = " + lapNumber +
                ", Tempo da Volta = " + lapTime + "s" +
                "}\n";
    }

    public String toString2() {
        return "Piloto{" +
                "Codigo do Piloto = " + code +
                ", Nome do Piloto = '" + name + '\'' +
                ", Numero da Volta = " + lapNumber +
                ", Tempo da Volta = " + lapTime + "s" +
                "}\n";
    }

    @Override
    public int compareTo(Lap p) {
        if (this.lapTime < p.getLapTime()) {
            return -1;
        } else if (this.lapTime > p.getLapTime()) {
            return 1;
        }
        return 0;
    }

}
