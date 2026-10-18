package org.guilherme.ifsp.exercises.polymorphism.Employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employee {
    private String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }


    public double getYearsOfService() {
        LocalDate hoje = LocalDate.now();
        long anos = ChronoUnit.YEARS.between(this.dateOfEmployment, hoje);
        return (double) anos;
    }

    public double calculateBonus() {
        double anosDeServico = getYearsOfService();
        double bonus = this.salary * (anosDeServico * 0.05);
        return bonus;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", jobTitle='" + getJobTitle() + '\'' +
                ", salary=" + getSalary() +
                ", dateOfEmployment=" + getDateOfEmployment() +
                '}';
    }
}
