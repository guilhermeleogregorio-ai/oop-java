package org.guilherme.ifsp.exercises.Prova2.model;

import java.util.Objects;

abstract public class Declaracao {
    private int id;
    private double ganhoTributavel;
    private double valorJaPago;

    public Declaracao(int id, double ganhoTributavel, double valorJaPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorJaPago = valorJaPago;
    }

    final public double valorAPagar(){
        return  valorImposto() - valorJaPago;
    }

    abstract protected double valorImposto();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorJaPago() {
        return valorJaPago;
    }

    public void setValorJaPago(double valorJaPago) {
        this.valorJaPago = valorJaPago;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public void setGanhoTributavel(double ganhoTributavel) {
        this.ganhoTributavel = ganhoTributavel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return getId() == that.getId() && Double.compare(getGanhoTributavel(), that.getGanhoTributavel()) == 0 && Double.compare(getValorJaPago(), that.getValorJaPago()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGanhoTributavel(), getValorJaPago());
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
