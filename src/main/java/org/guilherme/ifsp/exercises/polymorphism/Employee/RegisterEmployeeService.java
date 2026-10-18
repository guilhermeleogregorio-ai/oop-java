package org.guilherme.ifsp.exercises.polymorphism.Employee;

import java.util.Optional;

public class RegisterEmployeeService{
    //Atributo privado para guardar a dependência
    private final Repository repository;

    //Injeção de Dependência pelo Construtor
    public RegisterEmployeeService(Repository repository) {
        this.repository = repository;
    }

    public void register(Employee e){
        Optional exist = repository.byId(e.getId());

        if(exist.isPresent()){
            throw new IllegalArgumentException("Funcionario com id" + e.getId() + "Já registrado");
        } else {
            repository.save(e);
            System.out.println("Funcionario registrado");
        }
    }
}
