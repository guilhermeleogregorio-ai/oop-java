package org.guilherme.ifsp.exercises.Prova3.ticket;

public class ExitTicketDto {
    private String plate;
    private String exit;
    private double fee;

    public ExitTicketDto(String plate, String exit, double fee) {
        this.plate = plate;
        this.fee = fee;
        this.exit = exit;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
