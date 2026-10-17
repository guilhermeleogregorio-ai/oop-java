package org.guilherme.ifsp.exercises.inheritance.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class PerHourEmployee extends Employee {
    private double hourlyRate;
    private int workedHour;

    public PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate) {
        super(id, name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    @Override
    public double salary(){
        return hourlyRate * workedHour;
    }

    @Override
    public String toString() {
        return "PerHourEmployee{" +
                "hourlyRate=" + getHourlyRate() +
                ", workedHour=" + getWorkedHour() +
                ", id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", jobTitle='" + getJobTitle() + '\'' +
                ", dateOfEmployment=" + getDateOfEmployment().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PerHourEmployee that = (PerHourEmployee) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getWorkedHour() {
        return workedHour;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setWorkedHour(int workedHour) {
        this.workedHour = workedHour;
    }
}

