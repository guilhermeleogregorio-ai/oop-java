package org.guilherme.ifsp.exercises.polymorphism.zoo;

class Owl extends Animal {
    public Owl(String name) {
        super(name);
    }

    @Override
    public void makeSound(){
        System.out.println("Pruuu Pruuu!");
    }
}
