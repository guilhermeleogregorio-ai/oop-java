package org.guilherme.ifsp.exercises.polymorphism.Employee;

import java.util.Optional;

public class FakeEmployeeRepository implements Repository<Employee, String> {
    private final Employee[] employees = new Employee[100];
    private int contador = 0;

    @Override
    public void save(Employee entity) {
        if (contador == employees.length) throw new IllegalStateException("Vetor cheio");
        employees[contador++] = entity;
    }

    @Override
    public Optional<Employee> byId(String id) {
        for (int i = 0; i < contador; i++)
            if (employees[i].getId().equals(id)) return Optional.of(employees[i]);
        return Optional.empty();
    }
}


