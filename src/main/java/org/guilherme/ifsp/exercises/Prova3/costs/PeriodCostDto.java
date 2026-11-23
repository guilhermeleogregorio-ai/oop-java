package org.guilherme.ifsp.exercises.Prova3.costs;

import java.util.List;

public class PeriodCostDto {
    private int hours;
    private double fee;

    public PeriodCostDto(int hours, double fee) {
        this.hours = hours;
        this.fee = fee;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
