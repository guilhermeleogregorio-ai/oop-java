package org.guilherme.ifsp.exercises.polymorphism.Employee;

import java.util.Optional;

public class RegisterEmployeeService {
    private final Repository<Employee, String> repository;

    public RegisterEmployeeService(Repository<Employee, String> repository) {
        this.repository = repository;
    }

    public void register(Employee e) {
        Optional<Employee> exist = repository.byId(e.getId());

        if (exist.isPresent()) {
            throw new IllegalArgumentException("Funcionário com id " + e.getId() + " já registrado");
        }
        repository.save(e);
        System.out.println("Funcionário registrado");
    }
}