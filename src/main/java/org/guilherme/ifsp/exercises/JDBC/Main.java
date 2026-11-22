package org.guilherme.ifsp.exercises.JDBC;

import org.guilherme.ifsp.exercises.JDBC.dao.ProductRepository;
import org.guilherme.ifsp.exercises.JDBC.model.Product;
import org.guilherme.ifsp.exercises.JDBC.util.Database;

public class Main {
    public static void main(String[] args) {
        Database.init();
        ProductRepository repo = new ProductRepository();
        repo.save(new Product("SC0001", "Computer", 2 ,4532.99));
        repo.findOne("SC0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));
        repo.update(new Product("SC0001", "Notebook", 3,5352.89));
        repo.findAll().forEach(System.out::println);
  //      repo.delete("SC0001");
        repo.findOne("SC0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));
    }
}
