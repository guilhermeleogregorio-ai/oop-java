package org.guilherme.ifsp.exercises.polymorphism.zoo;

public class Wolf extends Animal{
    public Wolf(String name) {
        super(name);
    }
    @Override
    public void makeSound(){
        System.out.println("Auuuuuuuuu!");
    }
    public void run(){
        System.out.println("Wolf is running!");
    }
}

