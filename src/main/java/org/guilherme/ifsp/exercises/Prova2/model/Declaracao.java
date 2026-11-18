package org.guilherme.ifsp.exercises.Prova2.model;

import java.util.Objects;

abstract public class Declaracao {
    private final int id;
    private final double ganhoTributavel;
    private final double valorJaPago;

    public Declaracao(int id, double ganhoTributavel, double valorJaPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorJaPago = valorJaPago;
    }

    final public double valorAPagar(){
        return  valorImposto() - valorJaPago;
    }

    abstract protected double valorImposto();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id && Double.compare(ganhoTributavel, that.ganhoTributavel) == 0 && Double.compare(valorJaPago, that.valorJaPago) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ganhoTributavel, valorJaPago);
    }
    public int getId() {
        return id;
    }

    public double getValorJaPago() {
        return valorJaPago;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    @Override
    public String toString() {
        return "Declaracao{" +
                "id=" + id +
                ", ganhoTributavel=" + ganhoTributavel +
                ", valorJaPago=" + valorJaPago +
                '}';
    }
}
