package org.guilherme.ifsp.exercises.polymorphism.Employee;

import java.util.Optional;

public class FindEmployeeService {
    private final Repository repository;

    public FindEmployeeService(Repository repository) {
        this.repository = repository;
    }

    public Optional<Employee> findById(String id){
        return repository.byId(id);
    }
}
