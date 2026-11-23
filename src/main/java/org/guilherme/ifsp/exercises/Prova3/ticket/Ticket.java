package org.guilherme.ifsp.exercises.Prova3.ticket;

import org.guilherme.ifsp.exercises.Prova3.customer.Customer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Ticket {
    private UUID ID;
    private Customer cliente;
    private LocalDateTime entry;
    private LocalDateTime exit;

    public Ticket(Customer cliente) {
        this.cliente = cliente;
        this.ID = UUID.randomUUID();
        this.entry = LocalDateTime.now();
    }

    public Ticket(UUID ID, Customer cliente, LocalDateTime entry) {
        this.ID = ID;
        this.cliente = cliente;
        this.entry = entry;
    }

    public LocalDateTime exit(){
        return this.exit = LocalDateTime.now();
    }

    public Duration parkingDuration(){
        LocalDateTime end = (this.exit != null ) ? this.exit : LocalDateTime.now();
        return Duration.between(this.entry, end);
    }

    public UUID  getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public Customer getCliente() {
        return cliente;
    }

    public void setCliente(Customer cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getEntry() {
        return entry;
    }

    public void setEntry(LocalDateTime entry) {
        this.entry = entry;
    }

    public LocalDateTime getExit() {
        return exit;
    }

    public void setExit(LocalDateTime exit) {
        this.exit = exit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(getID(), ticket.getID()) && Objects.equals(getCliente(), ticket.getCliente()) && Objects.equals(getEntry(), ticket.getEntry()) && Objects.equals(getExit(), ticket.getExit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getCliente(), getEntry(), getExit());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ID=" + ID +
                ", cliente=" + cliente +
                ", entry=" + entry +
                ", exit=" + exit +
                '}';
    }
}
