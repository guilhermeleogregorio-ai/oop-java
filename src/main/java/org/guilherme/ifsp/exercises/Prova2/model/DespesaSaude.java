package org.guilherme.ifsp.exercises.Prova2.model;

import java.util.Objects;

public class DespesaSaude extends Despesa{
    static final public double DEDUCAO_MAX = 1500.0;
    private String registroConselho;

    public DespesaSaude(int id, double valor, String descricao, String cnpj, String registroConselho) {
        super(id, valor, descricao, cnpj);
        this.registroConselho = registroConselho;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    public void setRegistroConselho(String registroConselho) {
        this.registroConselho = registroConselho;
    }


    @Override
    public String toString() {
        return "DespesaSaude{" +
                "registroConselho='" + registroConselho + '\'' +
                "} " + super.toString();
    }
}
