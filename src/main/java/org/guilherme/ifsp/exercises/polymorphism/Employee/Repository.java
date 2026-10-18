package org.guilherme.ifsp.exercises.polymorphism.Employee;

import java.util.Optional;

public interface Repository <T, ID> {

   void save(T entity);

   Optional<T> byId(ID id);



}
