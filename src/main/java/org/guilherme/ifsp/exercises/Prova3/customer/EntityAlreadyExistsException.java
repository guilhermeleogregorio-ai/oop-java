package org.guilherme.ifsp.exercises.Prova3.customer;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
