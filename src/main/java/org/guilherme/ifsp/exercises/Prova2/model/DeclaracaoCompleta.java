package org.guilherme.ifsp.exercises.Prova2.model;

import java.util.List;

public class DeclaracaoCompleta extends Declaracao {
    public DeclaracaoCompleta(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
    }

    private List<Despesa> gastos;

    @Override
    protected double valorImposto() {
        return valorImposto();
    }

    public void adicionarDespesa(Despesa d){
        if(d != null){
            this.gastos.add(d);
        }

    }

    public void removerDespesa(Despesa d){
        if(d != null){
            this.gastos.remove(d);
        }
    }

    private double totalDespesasDedutiveis(){
        return totalDespesasDedutiveis();
    }

    @Override
    public String toString() {
        return "DeclaracaoCompleta{} " + super.toString();
    }
}
