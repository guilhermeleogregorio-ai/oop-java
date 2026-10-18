package org.guilherme.ifsp.exercises.polymorphism.Employee;

import java.util.Optional;

public class FakeEmployeeRepository implements Repository{
    Employee[] employee = new Employee[100];


    private  int contador = 0;
    @Override
    public void save(Object entity) {
        if(employee.length == contador){
            throw new IllegalArgumentException("Vetor cheio");
        }else{
            employee[contador] = (Employee) entity;
            contador++;
        }
    }

    @Override
    public Optional byId(Object o) {
        for(int i = 0 ; i < contador ; i++){
            Employee e = employee[i];
            if(e.getId().equals((String)o)){
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }


}
