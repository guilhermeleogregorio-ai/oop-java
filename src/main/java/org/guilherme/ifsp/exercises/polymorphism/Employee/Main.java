package org.guilherme.ifsp.exercises.polymorphism.Employee;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        FakeEmployeeRepository repo = new FakeEmployeeRepository();
        RegisterEmployeeService serviceCadastro = new RegisterEmployeeService(repo);
        FindEmployeeService serviceBusca = new FindEmployeeService(repo);


        Employee emp = new Employee("101", "Guilherme", "Dev", 5000.0, LocalDate.of(2020, 5, 10));

        // Cadastrando
        serviceCadastro.register(emp);

        Optional<Employee> busca = serviceBusca.findById("101");
        if (busca.isPresent()) {
            Employee e = busca.get();
            System.out.println("Funcionário: " + e.getName());
            System.out.println("Anos de serviço: " + e.getYearsOfService());
            System.out.printf("Bônus calculado: R$ %.2f%n", e.calculateBonus());
        }
    }
}
