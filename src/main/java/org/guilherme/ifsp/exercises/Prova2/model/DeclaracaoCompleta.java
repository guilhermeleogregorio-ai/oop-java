package org.guilherme.ifsp.exercises.Prova2.model;

public class DeclaracaoCompleta extends Declaracao {
    public DeclaracaoCompleta(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
    }

    @Override
    protected double valorImposto() {
        return valorImposto();
    }

    public void adicionarDespesa(Despesa d){

    }

    public void removerDespesa(Despesa d){

    }

    private double totalDespesasDedutiveis(){
        return totalDespesasDedutiveis();
    }

    @Override
    public String toString() {
        return "DeclaracaoCompleta{} " + super.toString();
    }
}
