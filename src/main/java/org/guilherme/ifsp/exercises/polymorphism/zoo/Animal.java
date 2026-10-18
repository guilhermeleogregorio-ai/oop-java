package org.guilherme.ifsp.exercises.polymorphism.zoo;

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  abstract void makeSound();
}
