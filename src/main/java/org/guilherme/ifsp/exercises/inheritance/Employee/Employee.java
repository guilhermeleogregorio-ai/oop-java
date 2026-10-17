package org.guilherme.ifsp.exercises.inheritance.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public sealed abstract class Employee permits FullTimeEmployee, PerHourEmployee {
    String id;
    String name;
    String jobTitle;
    LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }

    public abstract  double salary();

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", jobTitle='" + getJobTitle() + '\'' +
                ", dateOfEmployment=" + getDateOfEmployment().format(DateTimeFormatter.ofPattern("HH/mm/yyyy")) +
                '}';
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getName() {
        return name;
    }

}
