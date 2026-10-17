package org.guilherme.inheritance.Employee;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("1", "Miguel petro", "Medico", LocalDate.of(2025, 10, 4), 5000);
        PerHourEmployee perHourEmployee = new PerHourEmployee("1", "Miguel petro", "Medico", LocalDate.of(2025, 10, 4), 200);

        System.out.printf(Locale.US, "%s , salario por mes employee: US$ %.2f\n", fullTimeEmployee.getName(),fullTimeEmployee.salary());
        System.out.printf(Locale.US,"%s, salario por horas employee: US$ %.2f\n\n", perHourEmployee.getName(),perHourEmployee.salary());


        System.out.printf("%s é o mesmo atuando como colaborador em tempo integral ou como funcionário remunerado por hora? %s\n\n", fullTimeEmployee.getName(),(fullTimeEmployee.equals(perHourEmployee) ? "Sim" : "Não"));


        System.out.printf("Hash code por mes employee %s: %d\n",fullTimeEmployee.getName(),fullTimeEmployee.hashCode());
        System.out.printf("Hash code por horas employee %s: %d\n",perHourEmployee.getName(),perHourEmployee.hashCode());

        perHourEmployee.setHourlyRate(60);
        perHourEmployee.setWorkedHour(480);

        fullTimeEmployee.setMonthlySalary(5000);

        System.out.println("\ntoString das classes FullTimeEmployee e PerHourEmploye :\n");
        System.out.println(fullTimeEmployee);
        System.out.println(perHourEmployee);


    }
}
