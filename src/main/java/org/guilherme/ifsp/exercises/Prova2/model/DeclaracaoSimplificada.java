package org.guilherme.ifsp.exercises.Prova2.model;

public class DeclaracaoSimplificada extends Declaracao {
    public DeclaracaoSimplificada(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
    }

    @Override
    public double valorImposto(){
     return valorImposto();
    }

    @Override
    public String toString() {
        return "DeclaracaoSimplificada{} " + super.toString();
    }
}
