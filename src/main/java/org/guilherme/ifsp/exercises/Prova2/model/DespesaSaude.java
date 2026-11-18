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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DespesaSaude that = (DespesaSaude) o;
        return Objects.equals(getRegistroConselho(), that.getRegistroConselho());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRegistroConselho());
    }

    @Override
    public String toString() {
        return "DespesaSaude{" +
                "registroConselho='" + registroConselho + '\'' +
                "} " + super.toString();
    }
}
